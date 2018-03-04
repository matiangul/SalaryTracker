package pl.angulski.salarytracker.di

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.runtime.App
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: App): Context = application
}
