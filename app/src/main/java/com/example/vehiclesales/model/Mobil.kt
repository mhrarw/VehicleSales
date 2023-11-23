package com.example.vehiclesales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Mobil")
data class Mobil(
    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,
    override val vehicleType: String,
    override val year: Int,
    override val color: String,
    override val price: Long,
    val engineMobil: String,
    val passengerCapacity: Int,
    val type: String
) : Vehicle(id, vehicleType, year, color, price)