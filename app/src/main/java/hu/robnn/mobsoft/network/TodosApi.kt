package hu.robnn.mobsoft.network

import hu.robnn.mobsoft.model.Todo
import hu.robnn.mobsoft.model.TodoResult
import hu.robnn.mobsoft.model.TodosResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface TodosApi {
    @GET("todos")
    fun getTodos(): Call<TodosResult>

    @POST("todos")
    fun createTodo(todo: Todo): Call<TodoResult>
}
