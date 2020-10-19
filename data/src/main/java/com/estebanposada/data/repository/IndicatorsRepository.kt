package com.estebanposada.data.repository

import com.estebanposada.data.source.LocalDataSource
import com.estebanposada.data.source.RemoteDataSource
import com.estebanposada.domain.IndicatorDetails

class IndicatorsRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getIndicators() {
        val indicators = remoteDataSource.getIndicators()
        localDataSource.saveIndicators(indicators)
    }

    suspend fun findByCode(code: String): IndicatorDetails {
        val info = remoteDataSource.getIndicatorInfo(code)
        localDataSource.saveIndicatorInfo(info)
        return localDataSource.findByCode(code)
    }

    suspend fun filterIndicators(filter: String): List<IndicatorDetails> {
        val query = "%${filter?.replace(' ', '%')}%"
        return localDataSource.filterIndicators(query)
    }
}