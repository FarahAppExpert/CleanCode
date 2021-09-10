package com.example.cleancode.intractors

import com.example.cleancode.data.Flower_Repository

class GetFlowerInformation (private val flowerRepository: Flower_Repository) {

    suspend operator fun invoke () = flowerRepository.getFlowerInformation()
}