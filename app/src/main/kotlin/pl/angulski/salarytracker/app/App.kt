package pl.angulski.salarytracker.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pl.angulski.salarytracker.app.di.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder().create(this)
    }
}
