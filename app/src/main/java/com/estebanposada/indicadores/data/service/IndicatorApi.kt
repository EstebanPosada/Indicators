package com.estebanposada.indicadores.data.service

import retrofit2.http.GET
import retrofit2.http.Path

interface IndicatorApi {

    @GET("api")
    suspend fun getIndicators(): Indicator

    @GET("api/{tipo_indicador}")
    suspend fun getIndicatorInfo(@Path("tipo_indicador") type: String) : IndicatorDetail
}