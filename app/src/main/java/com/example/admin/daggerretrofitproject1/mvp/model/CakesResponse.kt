package com.example.admin.daggerretrofitproject1.mvp.model

data class CakesResponse(val product: String,
                         val staffContacts: Array<CakesResponseStaffContacts>,
                         val releaseDate: String,
                         val cakes: Array<CakeResponseCakes>,
                         val version: Int)