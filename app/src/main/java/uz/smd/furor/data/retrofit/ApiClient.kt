package uz.smd.furor.data.retrofit

import uz.smd.furor.app.App
import uz.smd.furor.data.local.LocalStorage
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.smd.furor.data.retrofit.extensions.hasNetwork

object ApiClient{
    val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    val cacheSize = (10 * 1024 * 1024).toLong()
    val myCache = Cache(App.instance.cacheDir, cacheSize)

    val okHttpClient = OkHttpClient.Builder()
        .cache(myCache)
        .addInterceptor(logging)
        .addInterceptor(ChuckInterceptor(App.instance))
        .addInterceptor { chain ->
            var request = chain.request()
            request = if (hasNetwork(App.instance)!!)
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
            chain.proceed(request)
        }

        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://furorprogress.uz/test/fp/")
//        .baseUrl("https://2b5ad90acf1d.ngrok.io")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}