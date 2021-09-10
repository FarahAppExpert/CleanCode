package com.example.cleancode.framework

import android.content.Context
import com.example.cleancode.data.FlowerWithDataSource
import com.example.cleancode.domain.FlowerModel
import com.example.cleancode.framework.db.FlowerEntity
import com.example.cleancode.framework.db.FlowerReaderDatabase


class RoomFlowerDataSource(val context: Context) : FlowerWithDataSource {

  private val flowerDao = FlowerReaderDatabase.getInstance(context).flowerDao()

  override suspend fun add_Flower(flower: FlowerModel) {
    val flower_details = FileUtil.getDocumentDetails(context, flower.photo)

    return flowerDao.addFlowers(
        FlowerEntity(flower_details.productId, flower_details.category,
        flower_details.price, flower_details.instructions, flower_details.name, flower_details.photo)
    )
  }

  override suspend fun readAll_Flowers(): List<FlowerModel> = flowerDao.getFlowers().map {
    FlowerModel(
        it.category,
        it.price,
        it.instructions,
        it.name,
        it.photo,
        it.productId

    )
  }

  override suspend fun remove_Flower(flower: FlowerModel) = flowerDao.removeFlowers(
      FlowerEntity(flower.productId, flower.category, flower.price, flower.instructions,
      flower.name, flower.photo)
  )
}