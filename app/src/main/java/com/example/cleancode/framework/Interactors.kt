package com.example.cleancode.framework

import com.example.cleancode.intractors.*


data class Interactors(

    val addFlower: AddFlower,
    val getFlower: GetFlower,
    val removeFlower: RemoveFlower,
    val getFlowerInformation: GetFlowerInformation,
    val setFlowerInformation: SetFlowerInformation
)
