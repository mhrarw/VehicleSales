package com.example.vehiclesales.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vehiclesales.model.DeletionHistory
import com.example.vehiclesales.model.Mobil
import com.example.vehiclesales.model.Motor
import com.example.vehiclesales.model.Vehicle

@Dao
interface VehicleDao {
    @Query("SELECT * FROM Vehicle")
    fun getAllVehicles(): List<Vehicle>

    @Query("SELECT * FROM Motor")
    fun getAllMotor(): List<Motor>

    @Query("SELECT * FROM Mobil")
    fun getAllMobil(): List<Mobil>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicle(vehicle: Vehicle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMotor(motor: Motor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMobil(mobil: Mobil)

    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)

    @Delete
    suspend fun deleteMotor(motor: Motor)

    @Delete
    suspend fun deleteMobil(mobil: Mobil)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeletionHistory(deletionHistory: DeletionHistory)

    @Query("SELECT * FROM DeletionHistory ORDER BY deletionTimestamp DESC")
    fun getAllDeletionHistory(): List<DeletionHistory>
}