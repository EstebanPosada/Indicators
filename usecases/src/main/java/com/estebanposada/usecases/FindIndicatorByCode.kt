package com.estebanposada.usecases

import com.estebanposada.data.repository.IndicatorsRepository

class FindIndicatorByCode(private val indicatorsRepository: IndicatorsRepository) {
    suspend fun invoke(code: String) = indicatorsRepository.findByCode(code)
}