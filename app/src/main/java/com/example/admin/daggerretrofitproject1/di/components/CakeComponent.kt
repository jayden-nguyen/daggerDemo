package com.example.admin.daggerretrofitproject1.di.components

import android.content.Context
import com.example.admin.daggerretrofitproject1.di.modules.CakeModule
import com.example.admin.daggerretrofitproject1.di.scopes.PerActivity
import com.example.admin.daggerretrofitproject1.modules.home.MainActivity
import dagger.Component
import retrofit2.Retrofit

@PerActivity
@Component(modules = [CakeModule::class],dependencies = [ApplicationComponents::class])
interface CakeComponent {
    fun inject(mainActivity: MainActivity)
}