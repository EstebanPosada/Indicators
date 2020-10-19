package com.estebanposada.indicadores.data.database

import androidx.room.*
import com.estebanposada.indicadores.data.database.model.IndicatorDetail
import com.estebanposada.indicadores.data.database.model.IndicatorDetailUpdate

@Dao
interface IndicatorsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIndicators(indicators: List<IndicatorDetail>)

    @Query("SELECT * FROM indicatordetail")
    fun getIndicators(): List<IndicatorDetail>

    @Query("SELECT * FROM indicatordetail WHERE code LIKE :filter OR name LIKE :filter  ORDER BY name ASC")
    fun filterIndicators(filter: String): List<IndicatorDetail>

    @Query("SELECT COUNT(code) FROM indicatordetail")
    fun count(): Int

    @Query("SELECT * FROM indicatordetail WHERE code = :code")
    fun findByCode(code: String): IndicatorDetail

    @Update(entity = IndicatorDetail::class)
    fun updateIndicator(detailUpdate: IndicatorDetailUpdate)
}