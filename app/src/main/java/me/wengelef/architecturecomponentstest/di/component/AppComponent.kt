package me.wengelef.architecturecomponentstest.di.component

import android.content.Context
import dagger.Component
import me.wengelef.architecturecomponentstest.MainActivity
import me.wengelef.architecturecomponentstest.di.module.AppModule
import me.wengelef.architecturecomponentstest.di.module.RestModule
import javax.inject.Singleton

@Singleton @Component(modules = arrayOf(AppModule::class, RestModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun context(): Context
}