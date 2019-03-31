package hu.robnn.mobsoft

import dagger.Component
import hu.robnn.mobsoft.interactor.InteractorModule
import hu.robnn.mobsoft.network.NetworkModule
import hu.robnn.mobsoft.ui.UIModule
import hu.robnn.mobsoft.ui.main.TodosFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface TodoApplicationComponent {
    fun inject(todosFragment: TodosFragment)
}
