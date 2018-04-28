package pl.angulski.mobile.extension

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.experimental.Job

fun Lifecycle.job(): Job {
    return object : Job by Job(), LifecycleObserver {

        init {
            addObserver(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun destroy() = cancel()
    }
}
