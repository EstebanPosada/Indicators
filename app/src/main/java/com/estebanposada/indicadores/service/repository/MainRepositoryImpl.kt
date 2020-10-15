package com.estebanposada.indicadores.service.repository

import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(): MainRepository {
    override fun print(): String = "hi"
}