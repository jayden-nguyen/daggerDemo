package com.example.admin.daggerretrofitproject1.base

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.example.admin.daggerretrofitproject1.application.CakeApplication
import com.example.admin.daggerretrofitproject1.di.components.ApplicationComponents

abstract class BaseActivity: AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        ButterKnife.bind(this)
        println("Hello this is Base Activity")
        onViewReady(savedInstanceState,intent)
    }

    @CallSuper
    protected open fun onViewReady(savesInstanceState: Bundle?, intent: Intent) {
        resolveDaggerDependency()
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    open fun resolveDaggerDependency(){}

    protected fun showDialog(message: String) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progressDialog!!.setCancelable(true)
        }
        progressDialog!!.setMessage(message)
        progressDialog!!.show()
    }

    protected fun hideDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    }

    protected abstract fun getContentView():Int

    protected open fun getApplicationComponent(): ApplicationComponents {
        return (application as CakeApplication).getApplicationComponents()
    }
}