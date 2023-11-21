package com.example.vehiclesales.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VehicleDao {
    @Query("SELECT * FROM Vehicle")
    fun getAllVehicles(): LiveData<List<Vehicle>>
    //lihat stok kendaraan

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicle(vehicle: Vehicle)
    //penjualan kendaraan

    @Query("SELECT * FROM SaleDetails WHERE vehicleType = :vehicleType")
    fun getSalesReportByVehicleType(vehicleType: String): LiveData<List<SaleDetails>>
    //laporan penjualan per kendaraan
}