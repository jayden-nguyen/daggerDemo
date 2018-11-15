package com.example.admin.daggerretrofitproject1.di.modules

import com.example.admin.daggerretrofitproject1.api.CakeApiService
import com.example.admin.daggerretrofitproject1.base.BaseView
import com.example.admin.daggerretrofitproject1.di.scopes.PerActivity
import com.example.admin.daggerretrofitproject1.mvp.view.MainView
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CakeModule(private val mView: MainView) {

    @PerActivity
    @Provides
    fun provideApiService(retrofit: Retrofit): CakeApiService {
        return retrofit.create(CakeApiService::class.java)
    }

    @PerActivity
    @Provides
    fun provideView(): MainView {
        return mView
    }
}