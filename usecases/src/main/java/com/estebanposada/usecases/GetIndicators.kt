package com.estebanposada.usecases

import com.estebanposada.data.repository.IndicatorsRepository
import com.estebanposada.domain.IndicatorDetails


class GetIndicators (private val repository: IndicatorsRepository) {
    suspend fun invoke(): List<IndicatorDetails> = repository.getIndicators()
}