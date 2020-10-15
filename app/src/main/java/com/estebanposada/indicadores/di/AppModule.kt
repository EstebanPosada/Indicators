package com.estebanposada.indicadores.di

import com.estebanposada.indicadores.service.repository.MainRepository
import com.estebanposada.indicadores.service.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun mainProvider(): MainRepository = MainRepositoryImpl()
}