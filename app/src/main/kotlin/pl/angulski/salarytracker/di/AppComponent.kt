package pl.angulski.salarytracker.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import pl.angulski.salarytracker.di.salary.SalaryModule
import pl.angulski.salarytracker.runtime.App
import javax.inject.Singleton
import dagger.BindsInstance

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
