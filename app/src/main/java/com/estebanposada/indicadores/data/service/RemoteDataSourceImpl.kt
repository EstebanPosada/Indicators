package com.estebanposada.indicadores.data.service

import com.estebanposada.data.source.RemoteDataSource
import com.estebanposada.domain.IndicatorDetailUpdate
import com.estebanposada.domain.Indicators
import com.estebanposada.indicadores.data.toDomainIndicators
import com.estebanposada.indicadores.data.toIndicatorUpdate
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: IndicatorApi) : RemoteDataSource {
    override suspend fun getIndicators(): Indicators = api.getIndicators().toDomainIndicators()
    override suspend fun getIndicatorInfo(type: String): IndicatorDetailUpdate =
        api.getIndicatorInfo(type).toIndicatorUpdate()
}