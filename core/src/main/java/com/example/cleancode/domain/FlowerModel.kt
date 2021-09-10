package com.example.cleancode.domain

import java.io.Serializable

/*
 in the core model we add a domain layer we can add a model class which can take from Api or from internal data
 that we want to store it
 */
data class FlowerModel(
    val category: String,
    val price: Double,
    val instructions: String,
    val photo: String,
    val name: String,
    val productId: Int

): Serializable {
  companion object {
    val flower_model = FlowerModel("", 0.0, "", "", "", 0)
  }
}