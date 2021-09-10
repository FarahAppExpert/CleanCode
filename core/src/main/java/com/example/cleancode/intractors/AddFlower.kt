package com.example.cleancode.intractors

import com.example.cleancode.data.Flower_Repository
import com.example.cleancode.domain.FlowerModel

 class AddFlower (private val flowerRepository: Flower_Repository ) {

    suspend operator fun invoke (flower : FlowerModel)
    {
        flowerRepository.addFlower(flower)
    }

}