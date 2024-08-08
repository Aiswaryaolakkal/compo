package com.example.wom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConvertDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResult(result: ConversionResult)

    @Delete
    suspend fun deleteResult(result: ConversionResult)

    @Query("DELETE FROM result_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM result_table")
    fun getResults(): Flow<List<ConversionResult>>

}