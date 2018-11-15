package com.example.admin.daggerretrofitproject1.modules.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

import butterknife.BindView
import com.example.admin.daggerretrofitproject1.base.BaseActivity
import com.example.admin.daggerretrofitproject1.R
import com.example.admin.daggerretrofitproject1.di.components.DaggerApplicationComponents
import com.example.admin.daggerretrofitproject1.di.components.DaggerCakeComponent
import com.example.admin.daggerretrofitproject1.di.modules.CakeModule
import com.example.admin.daggerretrofitproject1.modules.home.adapter.CakeAdapter
import com.example.admin.daggerretrofitproject1.mvp.model.Cake
import com.example.admin.daggerretrofitproject1.mvp.presenter.CakePresenter
import com.example.admin.daggerretrofitproject1.mvp.view.MainView
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @BindView(R.id.cake_list) protected lateinit var mCakeList: RecyclerView

    override fun getContentView(): Int = R.layout.activity_main

    @Inject
    lateinit var mPresenter: CakePresenter

    @Inject
    lateinit var mTestObject: TestObject

    private lateinit var mCakeAdapter: CakeAdapter

    override fun onViewReady(savesInstanceState: Bundle?, intent: Intent) {
        super.onViewReady(savesInstanceState, intent)
        initializeList()
        mPresenter.getCakes()
        val result = mTestObject.testMethod()
        println("result is $result")
    }

    private fun initializeList() {
        mCakeList.setHasFixedSize(true)
        mCakeList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mCakeAdapter = CakeAdapter(layoutInflater)
        mCakeList.adapter = mCakeAdapter
    }

    override fun resolveDaggerDependency() {
        DaggerCakeComponent.builder()
                .applicationComponents(getApplicationComponent())
                .cakeModule(CakeModule(this))
                .build().inject(this)

    }

    override fun onCakesLoaded(cakes: List<Cake>) {
        mCakeAdapter.addCakes(cakes)
    }

    override fun onHideDialog() {
        hideDialog()
    }

    override fun onShowDialog(s: String) {
        showDialog(message = s)
    }

    override fun onShowToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

}
