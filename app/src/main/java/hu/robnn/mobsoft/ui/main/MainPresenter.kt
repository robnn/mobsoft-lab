package hu.robnn.mobsoft.ui.main

import hu.robnn.mobsoft.interactor.todos.TodosInteractor
import hu.robnn.mobsoft.interactor.todos.event.GetTodosEvent
import hu.robnn.mobsoft.model.Todo
import hu.robnn.mobsoft.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val todosInteractor: TodosInteractor) : Presenter<TodosScreen>(){
    override fun attachScreen(screen: TodosScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshTodos() {
        executor.execute {
            todosInteractor.getTodos()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetTodosEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.todos != null) {
                    screen?.showTodos(event.todos as MutableList<Todo>)
                }

            }
        }
    }
}