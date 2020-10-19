package com.estebanposada.indicadores.data.service

import com.google.gson.annotations.SerializedName

data class Indicator(
    val version: String,
    @SerializedName("autor")
    val author: String,
    @SerializedName("fecha")
    val date: String,
    @SerializedName("uf")
    val uf: IndicatorDetail,
    val ivp: IndicatorDetail,
    @SerializedName("dolar")
    val dollar: IndicatorDetail,
    @SerializedName("dolar_intercambio")
    val dollarExchange: IndicatorDetail,
    val euro: IndicatorDetail,
    val ipc: IndicatorDetail,
    val utm: IndicatorDetail,
    val imacec: IndicatorDetail,
    val tpm: IndicatorDetail,
    @SerializedName("libra_cobre")
    val copper: IndicatorDetail,
    @SerializedName("tasa_desempleo")
    val unemploymentRate: IndicatorDetail,
    val bitcoin: IndicatorDetail
)

data class IndicatorDetail(
    val version: String? = EMPTY,
    @SerializedName("autor")
    val author: String? = EMPTY,
    @SerializedName("codigo")
    val code: String,
    @SerializedName("nombre")
    val name: String,
    @SerializedName("unidad_medida")
    val measurementUnit: String,
    @SerializedName("fecha")
    val date: String,
    @SerializedName("valor")
    val value: Double? = 0.0,
    val serie: List<Serie>? = listOf()
)

data class Serie(
    @SerializedName("fecha")
    val date: String,
    @SerializedName("valor")
    val value: Double
)

const val EMPTY = ""

