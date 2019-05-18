package hu.robnn.mobsoft.mock

import hu.robnn.mobsoft.model.Todo
import hu.robnn.mobsoft.model.TodosResult
import hu.robnn.mobsoft.network.TodosApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class MockTodosApi: TodosApi {
    companion object {
        var todosResult: TodosResult? = null
    }
    override fun getTodos(): Call<TodosResult> {
        val todos = ArrayList<Todo>()
        val todo = Todo()
        todo.description = "test description"
        todo.creationDate = Date()
        todos.add(todo)
        todosResult = TodosResult(todos)

        return object : Call<TodosResult> {
            @Throws(IOException::class)
            override fun execute(): Response<TodosResult> {
                return Response.success(todosResult)
            }

            override fun enqueue(callback: Callback<TodosResult>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<TodosResult> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
    }
}