package com.example.cleancode.framework.db

import com.example.cleancode.data.openFlower_DataSource
import com.example.cleancode.domain.FlowerModel


class InMemoryOpenFlowerDataSource : openFlower_DataSource {

  private var openFlower: FlowerModel = FlowerModel.flower_model



  override fun setOpen_FlowerDataSource(flower_model: FlowerModel) {
    openFlower = flower_model
  }

  override fun getOpen_FlowerDataSource() = openFlower
}