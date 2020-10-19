package com.estebanposada.indicadores.data.database

import com.estebanposada.data.source.LocalDataSource
import com.estebanposada.domain.IndicatorDetailUpdate
import com.estebanposada.domain.IndicatorDetails
import com.estebanposada.domain.Indicators
import com.estebanposada.indicadores.data.toIndicatorDetail
import com.estebanposada.indicadores.data.toRoomIndicatorDetail
import com.estebanposada.indicadores.data.toRoomIndicatorUpdate

class RoomDataSource(private val dao: IndicatorsDao) : LocalDataSource {
    override fun isEmpty(): Boolean = dao.count() <= 0

    override fun getIndicators(): List<IndicatorDetails> =
        dao.getIndicators().map { it.toIndicatorDetail() }

    override fun saveIndicators(ind: Indicators) {
        val indicators = listOf(
            ind.uf,
            ind.ivp,
            ind.dollar,
            ind.dollarExchange,
            ind.euro,
            ind.ipc,
            ind.utm,
            ind.imacec,
            ind.tpm,
            ind.copper,
            ind.unemploymentRate,
            ind.bitcoin,
        )
        dao.insertIndicators(indicators.map { it.toRoomIndicatorDetail() })
    }

    override fun findByCode(code: String): IndicatorDetails =
        dao.findByCode(code).toIndicatorDetail()

    override fun saveIndicatorInfo(info: IndicatorDetailUpdate) {
        dao.updateIndicator(info.toRoomIndicatorUpdate())
    }

    override fun filterIndicators(filter: String): List<IndicatorDetails> =
        dao.filterIndicators(filter).map { it.toIndicatorDetail() }
}