package me.wengelef.architecturecomponentstest

import android.app.Application
import me.wengelef.architecturecomponentstest.di.component.AppComponent
import me.wengelef.architecturecomponentstest.di.component.DaggerAppComponent
import me.wengelef.architecturecomponentstest.di.module.AppModule
import me.wengelef.architecturecomponentstest.di.module.RestModule
import timber.log.Timber

class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .restModule(RestModule())
                .build()
    }
}