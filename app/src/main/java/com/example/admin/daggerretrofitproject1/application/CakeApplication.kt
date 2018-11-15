package com.example.admin.daggerretrofitproject1.application

import android.app.Application
import com.example.admin.daggerretrofitproject1.di.components.ApplicationComponents
import com.example.admin.daggerretrofitproject1.di.components.DaggerApplicationComponents
import com.example.admin.daggerretrofitproject1.di.modules.ApplicationModule

class CakeApplication: Application() {

    private lateinit var mApplicationComponents: ApplicationComponents

    override fun onCreate() {
        super.onCreate()

        initApplicationComponent()
    }

    private fun initApplicationComponent() {
        mApplicationComponents = DaggerApplicationComponents.builder()
                .applicationModule(ApplicationModule( this))
                .build()
    }

    fun getApplicationComponents(): ApplicationComponents {
        return mApplicationComponents
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}