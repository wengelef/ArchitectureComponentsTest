package me.wengelef.architecturecomponentstest.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import me.wengelef.architecturecomponentstest.service.GitHubUserService
import me.wengelef.architecturecomponentstest.service.GithubRepoService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton @Module
class RestModule {

    @Provides @Singleton fun provideRetrofit(okHttpClient: OkHttpClient,
                                             gson: Gson): Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides @Singleton fun provideGson(): Gson = GsonBuilder()
            .setPrettyPrinting()
            .create()

    @Provides @Singleton fun provideHttpClient(loggingInterceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
            .followRedirects(false)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides @Singleton fun provideHttpLoggingInterceptor(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides @Singleton fun provideUserService(retrofit: Retrofit): GitHubUserService = retrofit.create(GitHubUserService::class.java)

    @Provides @Singleton fun provideRepoService(retrofit: Retrofit): GithubRepoService = retrofit.create(GithubRepoService::class.java)
}