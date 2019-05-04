package hu.robnn.mobsoft

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import hu.robnn.mobsoft.interactor.InteractorModule
import hu.robnn.mobsoft.network.NetworkModule
import hu.robnn.mobsoft.ui.UIModule
import hu.robnn.mobsoft.ui.create.CreateFragment
import hu.robnn.mobsoft.ui.main.TodosFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface TodoApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TodoApplicationComponent

        fun uIModule(uiModule: UIModule): Builder
    }

    fun inject(todosFragment: TodosFragment)
    fun inject(createFragment: CreateFragment)
    fun inject(application: TodoApplication)
}
