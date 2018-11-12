package com.example.admin.daggerretrofitproject1.mvp.model

import java.io.Serializable

data class Cake(val id: Int,
                val title: String,
                val previewDescription: String,
                val detailDescription: String,
                val imageUrl: String): Serializable