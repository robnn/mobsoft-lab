package hu.robnn.mobsoft.interactor

import dagger.Module
import dagger.Provides
import hu.robnn.mobsoft.interactor.todos.TodosInteractor
import hu.robnn.mobsoft.network.TodosApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideTodosInteractor(todosApi: TodosApi) = TodosInteractor(todosApi)
}