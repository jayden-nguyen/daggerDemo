package com.example.admin.daggerretrofitproject1.base

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


abstract class BasePresenter<V: BaseView> {
    @Inject
    lateinit var mView: V

    protected open fun getView(): V {
        return mView
    }

    protected open fun <T> subscribe(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}