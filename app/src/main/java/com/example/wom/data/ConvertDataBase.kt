package com.example.wom.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ConversionResult::class],version = 1)
abstract class ConvertDataBase :RoomDatabase() {
    abstract val convertDAO:ConvertDAO
}

