package hu.robnn.mobsoft

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import hu.robnn.mobsoft.interactor.InteractorModule
import hu.robnn.mobsoft.mock.MockNetworkModule
import hu.robnn.mobsoft.test.CreateTest
import hu.robnn.mobsoft.test.MainTest
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent: TodoApplicationComponent {
    fun inject(mainTest: MainTest)
    fun inject(createTest: CreateTest)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TodoApplicationComponent

        fun testModule(testModule: TestModule): Builder
    }
}