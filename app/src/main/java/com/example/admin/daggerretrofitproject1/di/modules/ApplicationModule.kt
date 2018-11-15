package com.example.admin.daggerretrofitproject1.di.modules

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule( private val mContext: Context) {

    @Singleton
    @Provides
    @Named("conver-1")
    fun provideGsonConverterFactory(): GsonConverterFactory{
        val factory = GsonConverterFactory.create()
        return factory
    }

    @Singleton
    @Provides
    @Named("ok-1")
    fun provideOkHttpClient1(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    @Named("ok-2")
    fun provideOkHttpClient2(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("ok-1") client: OkHttpClient): Retrofit {
        val factory = GsonConverterFactory.create()
        val factory1 = RxJava2CallAdapterFactory.create()
        return Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com"
                )
                .addConverterFactory(factory)
                .addCallAdapterFactory(factory1)
                .client(client)
                .build()
    }

    @Singleton
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideContext(): Context {
        return mContext
    }

}