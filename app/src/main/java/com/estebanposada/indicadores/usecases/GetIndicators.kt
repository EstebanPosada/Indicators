package com.estebanposada.indicadores.usecases

import com.estebanposada.indicadores.data.database.Indicator
import com.estebanposada.indicadores.service.repository.MainRepository
import javax.inject.Inject

class GetIndicators @Inject constructor(private  val repository: MainRepository) {
    suspend fun invoke(): Indicator = repository.getData()
}