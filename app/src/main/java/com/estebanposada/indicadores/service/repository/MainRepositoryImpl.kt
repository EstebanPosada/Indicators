package com.estebanposada.indicadores.service.repository

import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    MainRepository {

    override suspend fun getData() =
        remoteDataSource.getData()

}