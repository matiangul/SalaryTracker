package pl.angulski.salarytracker.app.di

import dagger.Component
import pl.angulski.salarytracker.app.App
import pl.angulski.salarytracker.app.salary.di.SalaryModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        SalaryModule::class,
        ViewsModule::class
    ]
)
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<App>()
}
