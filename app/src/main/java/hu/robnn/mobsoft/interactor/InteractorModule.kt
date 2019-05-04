package hu.robnn.mobsoft.interactor

import android.app.Application
import dagger.Module
import dagger.Provides
import hu.robnn.mobsoft.dao.TodoRepository
import hu.robnn.mobsoft.interactor.todos.TodosInteractor
import hu.robnn.mobsoft.network.TodosApi
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideTodosInteractor(todosApi: TodosApi, todosRepository: TodoRepository) = TodosInteractor(todosApi, todosRepository)

    @Provides
    @Singleton
    fun provideTodoRepository(application: Application) = TodoRepository(application)
}