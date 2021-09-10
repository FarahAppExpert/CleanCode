package com.example.cleancode.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FlowerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FlowerReaderDatabase : RoomDatabase() {

  companion object {

    private const val DATABASE_NAME = "reader.db"

    private var instance: FlowerReaderDatabase? = null

    private fun create(context: Context): FlowerReaderDatabase =
        Room.databaseBuilder(context, FlowerReaderDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    fun getInstance(context: Context): FlowerReaderDatabase =
        (instance ?: create(context)).also { instance = it }
  }

  abstract fun flowerDao(): FlowerDao

}