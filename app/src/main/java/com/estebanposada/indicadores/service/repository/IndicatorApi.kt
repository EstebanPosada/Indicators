package com.estebanposada.indicadores.service.repository

import com.estebanposada.indicadores.data.database.Indicator
import retrofit2.http.GET

interface IndicatorApi {

    @GET("api")
    suspend fun getIndicators(): Indicator
}