package pl.angulski.salarytracker.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.angulski.salarytracker.app.App
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: App): Context = application
}
