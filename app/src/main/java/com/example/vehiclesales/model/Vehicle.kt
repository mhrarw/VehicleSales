package com.example.vehiclesales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Vehicle")
open class Vehicle(
    @PrimaryKey(autoGenerate = true)
    open val id: Long = 0,
    open val year: Long,
    open val color: String,
    open val price: Double
)