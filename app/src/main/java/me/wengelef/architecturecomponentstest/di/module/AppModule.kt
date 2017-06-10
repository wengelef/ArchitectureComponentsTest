package me.wengelef.architecturecomponentstest.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton @Module
class AppModule(private val context: Context) {

    @Provides @Singleton fun provideContext() = context
}