package hu.robnn.mobsoft.network

import hu.robnn.mobsoft.model.TodosResult
import retrofit2.Call
import retrofit2.http.GET

interface TodosApi {
    @GET("todos")
    fun getTodos(): Call<TodosResult>
}
