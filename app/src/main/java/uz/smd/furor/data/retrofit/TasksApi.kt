package uz.smd.furor.data.retrofit

import retrofit2.Call
import retrofit2.http.*
import uz.smd.furor.data.entities.*

interface TasksApi {
    /**
     * 1. Get all tasks
     * */
    @GET("test-tasks")
    fun tasks(): Call<ResponseData<List<Tasks>>>

    /**
     * 2. Get all statuses
     * */
    @GET("task-statuses")
    fun statuses(): Call<ResponseData<List<Statuses>>>

    /**
     * 3. Get all types
     * */
    @GET("task-types")
    fun types(): Call<ResponseData<List<Types>>>
/**
 * 4 Get all priorities
 * */
    @GET("task-priorities")
    fun priorities(): Call<ResponseData<List<Priorities>>>
}