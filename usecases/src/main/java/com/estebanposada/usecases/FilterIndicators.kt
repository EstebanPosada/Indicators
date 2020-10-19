package com.estebanposada.usecases

import com.estebanposada.data.repository.IndicatorsRepository

class FilterIndicators(private val indicatorsRepository: IndicatorsRepository) {
    suspend fun invoke(filter: String) = indicatorsRepository.filterIndicators(filter)
}