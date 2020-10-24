package uz.smd.furor.data.entities

data class ResponseData<T>(
    val total: Int=87,
    val rows: T? = null
)