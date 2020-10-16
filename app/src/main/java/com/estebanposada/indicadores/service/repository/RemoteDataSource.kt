package com.estebanposada.indicadores.service.repository

import com.estebanposada.indicadores.data.database.Indicator

interface RemoteDataSource {
    suspend fun getData(): Indicator
}