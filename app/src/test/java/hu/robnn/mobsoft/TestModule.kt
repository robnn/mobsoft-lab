package hu.robnn.mobsoft

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.robnn.mobsoft.interactor.todos.TodosInteractor
import hu.robnn.mobsoft.ui.create.CreatePresenter
import hu.robnn.mobsoft.ui.main.MainPresenter
import hu.robnn.mobsoft.utils.UiExecutor
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {
    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter(executor: Executor, todosInteractor: TodosInteractor) = MainPresenter(executor, todosInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()

    @Provides
    @Singleton
    fun provideCreatePresenter(executor: Executor, todosInteractor: TodosInteractor) = CreatePresenter(executor, todosInteractor)


}