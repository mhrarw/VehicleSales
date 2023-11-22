package com.example.vehiclesales.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vehiclesales.model.SaleDetails
import com.example.vehiclesales.model.Vehicle

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