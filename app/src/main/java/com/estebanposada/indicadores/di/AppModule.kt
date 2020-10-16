package com.estebanposada.indicadores.di

import com.estebanposada.indicadores.service.repository.*
import com.estebanposada.indicadores.usecases.GetIndicators
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun mainProvider(remoteDataSource: RemoteDataSource): MainRepository =
        MainRepositoryImpl(remoteDataSource)

    @Singleton
    @Provides
    fun remoteDataSourceProvider(api: IndicatorApi): RemoteDataSource = RemoteDataSourceImpl(api)

    @Singleton
    @Provides
    fun getIndicatorProvider(repository: MainRepository): GetIndicators = GetIndicators(repository)
}