package com.estebanposada.indicadores.data.database

import com.google.gson.annotations.SerializedName

data class Indicator(
    val version: String,
    @SerializedName("autor")
    val author: String,
    @SerializedName("fecha")
    val date: String,
    @SerializedName("uf")
    val uf: generic,
    val ivp: generic,
    @SerializedName("dolar")
    val dollar: dolar,
    @SerializedName("dolar_intercambio")
    val dollarExchange: dolar_intercambio,
    val euro: euro,
    val ipc: ipc,
    val utm: utm,
    val imacec: imacec,
    val tpm: tpm,
    @SerializedName("libra_cobre")
    val copper: libra_cobre,
    @SerializedName("tasa_desempleo")
    val unemploymentRate: tasa_desempleo,
    val bitcoin: bitcoin
)

data class generic(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class uf(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)


data class ivp(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class dolar(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class dolar_intercambio(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class euro(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class ipc(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class utm(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class imacec(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class tpm(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class libra_cobre(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class tasa_desempleo(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)

data class bitcoin(
    val codigo: String,
    val nombre: String,
    val unidad_medida: String,
    val fecha: String,
    val valor: Double
)