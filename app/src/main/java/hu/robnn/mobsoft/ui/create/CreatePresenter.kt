package hu.robnn.mobsoft.ui.create

import hu.robnn.mobsoft.interactor.todos.TodosInteractor
import hu.robnn.mobsoft.interactor.todos.event.CreateTodoEvent
import hu.robnn.mobsoft.interactor.todos.event.GetTodosEvent
import hu.robnn.mobsoft.model.Todo
import hu.robnn.mobsoft.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class CreatePresenter @Inject constructor(private val executor: Executor, private val todosInteractor: TodosInteractor) : Presenter<CreateScreen>(){
    override fun attachScreen(screen: CreateScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun createTodo(todo: Todo) {
        executor.execute {
            todosInteractor.createTodo(todo)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: CreateTodoEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                screen?.closeCreateScreen()
            }
        }
    }
}