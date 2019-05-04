package hu.robnn.mobsoft.interactor.todos

import android.util.Log
import hu.robnn.mobsoft.dao.TodoRepository
import hu.robnn.mobsoft.interactor.todos.event.CreateTodoEvent
import hu.robnn.mobsoft.interactor.todos.event.GetTodosEvent
import hu.robnn.mobsoft.model.Todo
import hu.robnn.mobsoft.network.TodosApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class TodosInteractor @Inject constructor(private var todosApi: TodosApi, private var todoRepository: TodoRepository){

    fun getTodos() {
        val event = GetTodosEvent()
        try {
            val todosCall = todosApi.getTodos()

            val response = todosCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.todos = response.body()?.todos as MutableList<Todo>?
            event.todos!!.addAll(todoRepository.getAllTodos().value!!)
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun createTodo(todo: Todo) {
        todoRepository.insert(todo)
    }
}