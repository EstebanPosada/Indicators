package com.estebanposada.data.source

import com.estebanposada.domain.IndicatorDetailUpdate
import com.estebanposada.domain.Indicators

interface RemoteDataSource {
    suspend fun getIndicators(): Indicators
    suspend fun getIndicatorInfo(type: String): IndicatorDetailUpdate
}