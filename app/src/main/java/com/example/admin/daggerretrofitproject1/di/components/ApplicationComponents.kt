package com.example.admin.daggerretrofitproject1.di.components

import android.content.Context
import com.example.admin.daggerretrofitproject1.application.CakeApplication
import com.example.admin.daggerretrofitproject1.di.modules.ApplicationModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponents {
    fun exposeRetrofit(): Retrofit
    fun exposeContext(): Context
}
