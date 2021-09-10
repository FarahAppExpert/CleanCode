package com.example.cleancode.data

import com.example.cleancode.domain.FlowerModel

interface FlowerWithDataSource {

    suspend fun add_Flower(flower_model: FlowerModel)

    suspend fun remove_Flower(flower_model: FlowerModel)

    suspend fun readAll_Flowers () : List<FlowerModel>

}