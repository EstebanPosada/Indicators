package com.estebanposada.indicadores.data

import com.estebanposada.domain.IndicatorDetailUpdate
import com.estebanposada.domain.IndicatorDetails
import com.estebanposada.domain.Indicators
import com.estebanposada.domain.Serie
import com.estebanposada.indicadores.EMPTY
import com.estebanposada.indicadores.data.database.model.IndicatorDetail as DomainIndicatorDetail
import com.estebanposada.indicadores.data.database.model.IndicatorDetailUpdate as DomainUpdate
import com.estebanposada.indicadores.data.database.model.Serie as DomainSerie
import com.estebanposada.indicadores.data.service.Indicator as ServerIndicator
import com.estebanposada.indicadores.data.service.IndicatorDetail as ServerIndicatorDetail
import com.estebanposada.indicadores.data.service.Serie as ServerSerie

fun IndicatorDetails.toRoomIndicatorDetail() = DomainIndicatorDetail(
    code, name, measurementUnit, date, value, version, author, series.map { it.toRoomSerie() }
)

fun IndicatorDetails.toRoomIndicatorDetailUpdate() = DomainUpdate(
    code, version, author, series.map { it.toRoomSerie() }
)

fun DomainIndicatorDetail.toIndicatorDetail() = IndicatorDetails(
    code, name, measurementUnit, date, value, version, author, series.map { it.toSerie() }
)

fun ServerIndicator.toDomainIndicators() = Indicators(
    version,
    author,
    date,
    uf.toDomainIndicatorDetails(),
    ivp.toDomainIndicatorDetails(),
    dollar.toDomainIndicatorDetails(),
    dollarExchange.toDomainIndicatorDetails(),
    euro.toDomainIndicatorDetails(),
    ipc.toDomainIndicatorDetails(),
    utm.toDomainIndicatorDetails(),
    imacec.toDomainIndicatorDetails(),
    tpm.toDomainIndicatorDetails(),
    copper.toDomainIndicatorDetails(),
    unemploymentRate.toDomainIndicatorDetails(),
    bitcoin.toDomainIndicatorDetails()
)

fun ServerIndicatorDetail.toDomainIndicatorDetails() = IndicatorDetails(
    code,
    name,
    measurementUnit,
    date,
    value ?: 0.0,
    version ?: EMPTY,
    author ?: EMPTY,
    serie?.map { it.toDomainSerie() } ?: listOf()
)

fun ServerIndicatorDetail.toDomainIndicatorUpdate() = DomainUpdate(
    code,
    version ?: EMPTY,
    author ?: EMPTY,
    serie?.map { it.toRoomSerie() } ?: listOf()
)

fun ServerSerie.toDomainSerie() = Serie(
    date, value
)

fun ServerSerie.toRoomSerie() = DomainSerie(
    date, value
)

fun DomainSerie.toSerie() = Serie(
    date, value
)

fun Serie.toRoomSerie() = DomainSerie(
    date, value
)

fun IndicatorDetailUpdate.toRoomIndicatorUpdate() = DomainUpdate(
    code, version, author, series.map { it.toRoomSerie() }
)

fun ServerIndicatorDetail.toIndicatorUpdate() = IndicatorDetailUpdate(
    code, version ?: EMPTY, author ?: EMPTY, serie?.map { it.toDomainSerie() } ?: listOf()
)

