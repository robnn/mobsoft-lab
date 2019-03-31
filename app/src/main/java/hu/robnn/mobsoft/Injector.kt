package hu.robnn.mobsoft

import android.app.Activity
import android.support.v4.app.Fragment


val Activity.injector: TodoApplicationComponent
    get() {
        return (this.applicationContext as TodoApplication).injector
    }

val Fragment.injector: TodoApplicationComponent
    get() {
        return (this.context!!.applicationContext as TodoApplication).injector
    }

