package com.example.cleancode.data

import com.example.cleancode.domain.FlowerModel


/*
 in the core model as well we add the data layer we add the repostory of the data which linked with domain layer
 we uuse the same model and we create a repostory to it
 we add the data case interface.
 */

class Flower_Repository (val flowers_data_source : FlowerWithDataSource, val open_flowers_dataspurce : openFlower_DataSource){

    val flower_data_source : FlowerWithDataSource
    val open_flower_dataspurce : openFlower_DataSource
    init {
        this.flower_data_source = flowers_data_source
        this.open_flower_dataspurce = open_flowers_dataspurce
    }

    suspend fun addFlower (flower : FlowerModel) = flower_data_source.add_Flower(flower)
    suspend fun getFlower() = flower_data_source.readAll_Flowers()
    suspend fun removeFlower (flower: FlowerModel) = flower_data_source.remove_Flower(flower)
            fun setFlowerInformation (flower : FlowerModel) = open_flower_dataspurce.setOpen_FlowerDataSource(flower)
            fun getFlowerInformation () = open_flowers_dataspurce.getOpen_FlowerDataSource()
}

