package com.example.admin.daggerretrofitproject1.mvp.presenter

import com.example.admin.daggerretrofitproject1.api.CakeApiService
import com.example.admin.daggerretrofitproject1.base.BasePresenter
import com.example.admin.daggerretrofitproject1.mapper.CakesMapper
import com.example.admin.daggerretrofitproject1.mvp.model.CakesResponse
import com.example.admin.daggerretrofitproject1.mvp.view.MainView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class CakePresenter @Inject constructor(): BasePresenter<MainView>(), Observer<CakesResponse> {

    @Inject
    lateinit var mApiService: CakeApiService

    @Inject
    lateinit var mCakeMapper: CakesMapper

    fun getCakes() {
        println("start get cakes")
        getView().onShowDialog("Loading Cake ...")
        val cakesResponseObservable = mApiService.getCakes()
        subscribe(cakesResponseObservable, this)
    }

    override fun onComplete() {
        getView().onHideDialog()
        getView().onShowToast("Cakes loading Complete ...")
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: CakesResponse) {
        val cakeList =  mCakeMapper.mapCakes(t)
        println("Cakes response is $t")
        getView().onCakesLoaded(cakeList)
    }

    override fun onError(e: Throwable) {
        println("Error is $e")
    }
}