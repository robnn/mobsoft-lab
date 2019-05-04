package hu.robnn.mobsoft.dao

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import hu.robnn.mobsoft.interactor.todos.event.CreateTodoEvent
import hu.robnn.mobsoft.model.Todo
import org.greenrobot.eventbus.EventBus
import java.lang.Exception

class TodoRepository(application: Application) {
    private var todoDao: TodoDao
    private var allTodos: LiveData<List<Todo>>

    init {
        val db = TodoDatabase.getDatabase(application)
        todoDao = db.todoDao()
        allTodos = todoDao.getTodos()
    }

    fun getAllTodos() = allTodos

    fun insert(todo: Todo): AsyncTask<Todo, Void, Void> = InsertAsyncTask(todoDao).execute(todo)

    companion object {
        private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: TodoDao) :
            AsyncTask<Todo, Void, Void>() {

            override fun doInBackground(vararg params: Todo): Void? {
                val event = CreateTodoEvent()
                try {
                    mAsyncTaskDao.insert(params[0])

                    event.code = 201
                    event.todo = params[0]
                } catch (e: Exception) {
                    event.throwable = e
                    EventBus.getDefault().post(event)
                }

                EventBus.getDefault().post(event)
                return null
            }
        }
    }

}