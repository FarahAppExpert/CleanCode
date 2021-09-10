package com.example.cleancode.data

import com.example.cleancode.domain.FlowerModel

interface openFlower_DataSource {

    fun setOpen_FlowerDataSource (flower_model: FlowerModel)

    fun getOpen_FlowerDataSource () : FlowerModel

}