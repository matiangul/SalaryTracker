package pl.angulski.mobile.extension

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
fun Lifecycle.scope(): CoroutineScope {
    return object : CoroutineScope by MainScope(), LifecycleObserver {

        init {
            addObserver(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun destroy() = cancel()
    }
}
