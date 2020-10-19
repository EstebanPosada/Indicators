package com.estebanposada.domain

data class Indicators(
    val version: String,
    val author: String,
    val date: String,
    val uf: IndicatorDetails,
    val ivp: IndicatorDetails,
    val dollar: IndicatorDetails,
    val dollarExchange: IndicatorDetails,
    val euro: IndicatorDetails,
    val ipc: IndicatorDetails,
    val utm: IndicatorDetails,
    val imacec: IndicatorDetails,
    val tpm: IndicatorDetails,
    val copper: IndicatorDetails,
    val unemploymentRate: IndicatorDetails,
    val bitcoin: IndicatorDetails
)

data class IndicatorDetails(
    val code: String,
    val name: String,
    val measurementUnit: String,
    val date: String,
    val value: Double,
    val version: String,
    val author: String,
    val series: List<Serie> = listOf()
)

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