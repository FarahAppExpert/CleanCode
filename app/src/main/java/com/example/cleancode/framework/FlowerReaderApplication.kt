package com.example.cleancode.framework

import android.app.Application
import com.example.cleancode.data.Flower_Repository
import com.example.cleancode.framework.db.InMemoryOpenFlowerDataSource
import com.example.cleancode.intractors.*

class FlowerReaderApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    val flowerRepository = Flower_Repository(
        RoomFlowerDataSource(this),
        InMemoryOpenFlowerDataSource()
    )

    FlowerViewModelFactory.inject(
        this,
        Interactors(
            AddFlower(flowerRepository),
            GetFlower(flowerRepository),
            RemoveFlower(flowerRepository),
            GetFlowerInformation(flowerRepository),
            SetFlowerInformation(flowerRepository)
        )
    )
  }

}