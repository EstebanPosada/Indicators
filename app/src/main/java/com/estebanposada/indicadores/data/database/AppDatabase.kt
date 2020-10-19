package com.estebanposada.indicadores.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.estebanposada.indicadores.data.database.model.Converter
import com.estebanposada.indicadores.data.database.model.IndicatorDetail

@Database(entities = [IndicatorDetail::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun indicatorDao(): IndicatorsDao
}