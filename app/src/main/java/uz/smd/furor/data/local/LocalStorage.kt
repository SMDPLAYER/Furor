package uz.smd.furor.data.local

import android.content.Context

class LocalStorage private constructor(context: Context) {
    companion object {
        lateinit var instance: LocalStorage; private set

        fun init(context: Context) {
            instance = LocalStorage(context)
        }
    }

    private val pref = context.getSharedPreferences("LocalStorage", Context.MODE_PRIVATE)
//    private val pref = SecurePreferences(context, "55555", "LocalStorage")

    var isFirst: Int by IntPreference(pref)
    var remember:Int by IntPreference(pref)



    fun clear() {
        pref.edit().clear().apply()
    }
}