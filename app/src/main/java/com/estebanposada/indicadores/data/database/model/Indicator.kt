package com.estebanposada.indicadores.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

class Indicator(
    val version: String,
    val author: String,
    val date: String,
    val uf: IndicatorDetail,
    val ivp: IndicatorDetail,
    val dollar: IndicatorDetail,
    val dollarExchange: IndicatorDetail,
    val euro: IndicatorDetail,
    val ipc: IndicatorDetail,
    val utm: IndicatorDetail,
    val imacec: IndicatorDetail,
    val tpm: IndicatorDetail,
    val copper: IndicatorDetail,
    val unemploymentRate: IndicatorDetail,
    val bitcoin: IndicatorDetail
)

@Entity
data class IndicatorDetail(
    @PrimaryKey
    val code: String,
    val name: String,
    val measurementUnit: String,
    val date: String,
    val value: Double,
    val version: String,
    val author: String,
    val series: List<Serie>
)

@Entity
data class IndicatorDetailUpdate(
    val code: String,
    val version: String,
    val author: String,
    val series: List<Serie>
)

data class Serie(
    val date: String,
    val value: Double
)