package com.example.cleancode.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FlowerList")
data class FlowerEntity(
    @PrimaryKey val productId: Int,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "instructions") val instructions: String,
    @ColumnInfo(name="name") val name : String,
    @ColumnInfo(name="photo") val photo : String

)
