package com.example.cleancode.presentation

import androidx.drawerlayout.widget.DrawerLayout
import com.example.cleancode.domain.FlowerModel


interface MainActivityDelegate {

    abstract val drawer_layout: DrawerLayout?

    fun openDocument(flower: FlowerModel)
}