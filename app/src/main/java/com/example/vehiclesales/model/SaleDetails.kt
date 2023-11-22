package com.example.vehiclesales.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class SaleDetails(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val vehicleId: Long, // id kendaraan yang dijual
    val buyerName: String,
    val buyerAddress: String,
    val buyerPhoneNumber: String,
    val paymentMethod: String,
    val totalSaleAmount: Double,
    val discountAmount: Double,
    val additionalFees: Double,
    val notes: String?,
    val vehicleType: String  // (Motor/Mobil)
)