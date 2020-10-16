package com.estebanposada.indicadores.service.repository

import com.estebanposada.indicadores.data.database.Indicator

class RemoteDataSourceImpl(private val api: IndicatorApi) : RemoteDataSource {
    override suspend fun getData(): Indicator = api.getIndicators()
}