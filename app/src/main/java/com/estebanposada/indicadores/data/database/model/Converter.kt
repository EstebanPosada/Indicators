package com.estebanposada.indicadores.data.database.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {
    private val gson = Gson()

    @TypeConverter
    fun dataToList(data: String): List<Serie> {
        val listType: Type = object : TypeToken<List<Serie>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(series: List<Serie>): String = gson.toJson(series)
}