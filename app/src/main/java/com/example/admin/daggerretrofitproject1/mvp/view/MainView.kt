package com.example.admin.daggerretrofitproject1.mvp.view

import com.example.admin.daggerretrofitproject1.base.BaseView
import com.example.admin.daggerretrofitproject1.mvp.model.Cake

interface MainView: BaseView {
    fun onCakesLoaded(cakes: List<Cake>)
    fun onHideDialog()
    fun onShowDialog(s: String)
    fun onShowToast(s: String)
}