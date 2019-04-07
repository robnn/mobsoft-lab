package hu.robnn.mobsoft.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.robnn.mobsoft.interactor.todos.TodosInteractor
import hu.robnn.mobsoft.ui.create.CreatePresenter
import hu.robnn.mobsoft.ui.main.MainPresenter
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, todosInteractor: TodosInteractor) = MainPresenter(executor, todosInteractor)

    @Provides
    @Singleton
    fun createPresenter(executor: Executor, todosInteractor: TodosInteractor) = CreatePresenter(executor, todosInteractor)


    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)

}