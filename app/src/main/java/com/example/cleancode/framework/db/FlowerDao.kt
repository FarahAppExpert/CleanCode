package com.example.cleancode.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface FlowerDao {

  @Insert(onConflict = REPLACE)
  suspend fun addFlowers(flower: FlowerEntity)

  @Query("SELECT * FROM document")
  suspend fun getFlowers(): List<FlowerEntity>

  @Delete
  suspend fun removeFlowers(flower: FlowerEntity)
}
