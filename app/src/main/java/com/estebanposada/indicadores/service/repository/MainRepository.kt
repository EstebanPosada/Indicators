package com.estebanposada.indicadores.service.repository

import com.estebanposada.indicadores.data.database.Indicator

interface MainRepository {
    suspend fun getData(): Indicator
}