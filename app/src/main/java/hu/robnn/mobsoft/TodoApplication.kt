package hu.robnn.mobsoft

import android.app.Application
import hu.robnn.mobsoft.ui.UIModule

class TodoApplication : Application() {
    lateinit var injector: TodoApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerTodoApplicationComponent.builder().uIModule(UIModule(this)).application(this).build()
    }
}
