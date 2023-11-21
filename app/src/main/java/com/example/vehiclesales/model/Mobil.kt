package com.example.vehiclesales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mobil(
    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,
    override val year: Int,
    override val color: String,
    override val price: Double,
    val engine: String,
    val passengerCapacity: Int,
    val type: String
) : Vehicle(id, year, color, price)