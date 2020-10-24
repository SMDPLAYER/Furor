package uz.smd.furor.data.retrofit


import androidx.lifecycle.ViewModel
import uz.smd.furor.data.retrofit.extensions.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.smd.furor.R
import uz.smd.furor.data.entities.*

class OverviewViewModel : ViewModel() {
    private val api = ApiClient.retrofit.create(TasksApi::class.java)

    fun tasks(block: (ResultData<ResponseData<List<Tasks>>>) -> Unit) {
        api.tasks().enqueue(object : Callback<ResponseData<List<Tasks>>> {
            override fun onFailure(call: Call<ResponseData<List<Tasks>>>, t: Throwable) {
                block(ResultData.failure(t))
            }

            override fun onResponse(
                call: Call<ResponseData<List<Tasks>>>,
                response: Response<ResponseData<List<Tasks>>>
            ) {
                val res = response.body()
                when {
                    res == null -> block(ResultData.resource(R.string.empty_body))
                    else -> block(ResultData.data(res))
                }
            }
        })
    }

    fun status(block: (ResultData<ResponseData<List<Statuses>>>) -> Unit) {
        api.statuses().enqueue(object : Callback<ResponseData<List<Statuses>>> {
            override fun onFailure(call: Call<ResponseData<List<Statuses>>>, t: Throwable) {
                block(ResultData.failure(t))
            }

            override fun onResponse(
                call: Call<ResponseData<List<Statuses>>>,
                response: Response<ResponseData<List<Statuses>>>
            ) {
                val res = response.body()
                when {
                    res == null -> block(ResultData.resource(R.string.empty_body))
                    else -> block(ResultData.data(res))
                }
            }
        })
    }

    fun type(block: (ResultData<ResponseData<List<Types>>>) -> Unit) {
        api.types().enqueue(object : Callback<ResponseData<List<Types>>> {
            override fun onFailure(call: Call<ResponseData<List<Types>>>, t: Throwable) {
                block(ResultData.failure(t))
            }

            override fun onResponse(
                call: Call<ResponseData<List<Types>>>,
                response: Response<ResponseData<List<Types>>>
            ) {
                val res = response.body()
                when {
                    res == null -> block(ResultData.resource(R.string.empty_body))
                    else -> block(ResultData.data(res))
                }
            }
        })
    }

    fun priorities(block: (ResultData<ResponseData<List<Priorities>>>) -> Unit) {
        api.priorities().enqueue(object : Callback<ResponseData<List<Priorities>>> {
            override fun onFailure(call: Call<ResponseData<List<Priorities>>>, t: Throwable) {
                block(ResultData.failure(t))
            }

            override fun onResponse(
                call: Call<ResponseData<List<Priorities>>>,
                response: Response<ResponseData<List<Priorities>>>
            ) {
                val res = response.body()
                when {
                    res == null -> block(ResultData.resource(R.string.empty_body))
                    else -> block(ResultData.data(res))
                }
            }
        })
    }
}
