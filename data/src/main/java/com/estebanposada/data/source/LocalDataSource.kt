package com.estebanposada.data.source

import com.estebanposada.domain.IndicatorDetailUpdate
import com.estebanposada.domain.IndicatorDetails
import com.estebanposada.domain.Indicators

interface LocalDataSource {
    fun isEmpty(): Boolean
    fun getIndicators(): List<IndicatorDetails>
    fun saveIndicators(ind: Indicators)
    fun findByCode(code: String): IndicatorDetails
    fun saveIndicatorInfo(info: IndicatorDetailUpdate)
    fun filterIndicators(filter: String): List<IndicatorDetails>
}