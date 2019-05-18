package hu.robnn.mobsoft

import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.ShadowLog

val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        val application = RuntimeEnvironment.application as TodoApplication
        val component = DaggerTestComponent.builder().testModule(TestModule(application.applicationContext)).application(application).build()
        application.injector = component
        return component as TestComponent
    }