package com.example.admin.daggerretrofitproject1.mapper

import com.example.admin.daggerretrofitproject1.mvp.model.Cake
import com.example.admin.daggerretrofitproject1.mvp.model.CakesResponse
import java.util.ArrayList
import javax.inject.Inject

class CakesMapper @Inject constructor() {
    fun mapCakes(response: CakesResponse): List<Cake> {
        val cakeList = ArrayList<Cake>()
        if (response != null) {
            val responseCakes = response.cakes
            if (responseCakes != null) {
                for (cake in responseCakes) {
                    val myCake = Cake(cake.id, cake.title,cake.previewDescription, cake.detailDescription, cake.image)
                    cakeList.add(myCake)
                }
            }

        }
        return cakeList
    }
}