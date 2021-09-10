package com.example.cleancode.intractors

import com.example.cleancode.data.Flower_Repository

class GetFlower (private val flowerRepository: Flower_Repository) {
    suspend operator fun invoke() = flowerRepository.getFlower()
}