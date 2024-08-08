package com.example.wom.data

import kotlinx.coroutines.flow.Flow

class ConversionRepositoryImp(private val dao: ConvertDAO) : ConversionRepository {
    override suspend fun insertResult(result: ConversionResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
       return dao.getResults()
    }
}