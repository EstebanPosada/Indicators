package com.estebanposada.usecases

import com.estebanposada.data.repository.IndicatorsRepository


class GetIndicators (private val repository: IndicatorsRepository) {
    suspend fun invoke() = repository.getIndicators()
}