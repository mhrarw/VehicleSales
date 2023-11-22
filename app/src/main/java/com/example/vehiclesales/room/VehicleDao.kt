package com.example.vehiclesales.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vehiclesales.model.Mobil
import com.example.vehiclesales.model.Motor
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

    @Query("SELECT * FROM Motor")
    fun getAllMotors(): LiveData<List<Motor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMotor(motor: Motor)

    @Query("SELECT * FROM Mobil")
    fun getAllMobils(): LiveData<List<Mobil>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMobil(mobil: Mobil)

    @Query("SELECT * FROM SaleDetails WHERE vehicleType = :vehicleType")
    fun getSalesReportByVehicleType(vehicleType: String): LiveData<List<SaleDetails>>
    //laporan penjualan per kendaraan

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSaleDetails(saleDetails: SaleDetails)
    //memasukkan detail penjualan
}