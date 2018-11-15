package com.example.admin.daggerretrofitproject1.modules.home

import javax.inject.Inject

class TestObject @Inject constructor() {
    fun testMethod() : String{
        return "INject success"
    }
}