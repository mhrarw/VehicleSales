package com.example.vehiclesales.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vehiclesales.model.Mobil
import com.example.vehiclesales.model.Motor
import com.example.vehiclesales.model.Vehicle
import kotlinx.coroutines.flow.Flow

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

}