package hu.robnn.mobsoft.utils

import android.os.Handler
import android.os.Looper

import java.util.concurrent.Executor

class UiExecutor : Executor {
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mHandler.post(command)
    }
}