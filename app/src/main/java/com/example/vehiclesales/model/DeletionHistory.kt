package com.example.vehiclesales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DeletionHistory")
data class DeletionHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val vehicleType: String,
    val year: Int,
    val color: String,
    val price: Long,
    val deletionTimestamp: Long
)