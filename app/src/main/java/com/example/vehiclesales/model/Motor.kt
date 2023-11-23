package com.example.vehiclesales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Motor")
data class Motor(
    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,
    override val year: Long,
    override val color: String,
    override val price: Double,
    val engine: String,
    val suspensionType: String,
    val transmissionType: String
) : Vehicle(id, year, color, price)