package pl.angulski.salarytracker.app.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance
import pl.angulski.salarytracker.app.App
import pl.angulski.salarytracker.app.salary.di.SalaryModule

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        SalaryModule::class,
        ActivitiesModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
    fun inject(app: App)
}
