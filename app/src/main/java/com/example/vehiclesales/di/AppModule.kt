package com.example.vehiclesales.di

import android.content.Context
import androidx.room.Room
import com.example.vehiclesales.repositories.VehicleRepository
import com.example.vehiclesales.room.VehicleDao
import com.example.vehiclesales.room.VehicleDatabase
import com.example.vehiclesales.ui.screen.VehicleViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRepository (dao: VehicleDao): VehicleRepository {
        return VehicleRepository(dao)
    }

    @Singleton
    @Provides
    fun getDao (database: VehicleDatabase): VehicleDao {
        return database.vehicleDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): VehicleDatabase {
        return Room.databaseBuilder(
            context.applicationContext,VehicleDatabase::class.java, "vehicle_database"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}