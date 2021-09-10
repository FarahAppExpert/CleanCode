package com.example.cleancode.intractors

import com.example.cleancode.data.Flower_Repository
import com.example.cleancode.domain.FlowerModel

class SetFlowerInformation (private val flowerRepository: Flower_Repository) {

    suspend operator fun invoke (flower : FlowerModel) = flowerRepository.setFlowerInformation(flower)

}