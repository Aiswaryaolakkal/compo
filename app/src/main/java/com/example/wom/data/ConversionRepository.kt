package com.example.wom.data

import kotlinx.coroutines.flow.Flow

interface ConversionRepository {
    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResults()
    fun getSavedResults(): Flow<List<ConversionResult>>
}