package com.example.cleancode.framework

import android.content.Context
import com.example.cleancode.data.FlowerWithDataSource
import com.example.cleancode.domain.FlowerModel


class Flower_RoomDataSource (public val context: Context) : FlowerWithDataSource
{

    override suspend fun add_Flower(flower_model: FlowerModel) {
        TODO("Not yet implemented")
    }

    override suspend fun remove_Flower(flower_model: FlowerModel) {
        TODO("Not yet implemented")
    }

    override suspend fun readAll_Flowers(): List<FlowerModel> {
        TODO("Not yet implemented")
    }

}