package com.example.vehiclesales.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vehiclesales.model.Mobil
import com.example.vehiclesales.model.Motor
import com.example.vehiclesales.model.Vehicle

@Database(entities = [Vehicle::class, Mobil::class, Motor::class], version = 2, exportSchema = false)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao

    companion object {
        @Volatile
        private var INSTANCE: VehicleDatabase? = null

        fun getDatabase(context: Context): VehicleDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VehicleDatabase::class.java,
                    "vehicle_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}