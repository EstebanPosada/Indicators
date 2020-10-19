package com.estebanposada.indicadores.di

import android.app.Application
import androidx.room.Room
import com.estebanposada.data.repository.IndicatorsRepository
import com.estebanposada.data.source.LocalDataSource
import com.estebanposada.data.source.RemoteDataSource
import com.estebanposada.indicadores.data.database.AppDatabase
import com.estebanposada.indicadores.data.database.RoomDataSource
import com.estebanposada.indicadores.data.service.IndicatorApi
import com.estebanposada.indicadores.data.service.RemoteDataSourceImpl
import com.estebanposada.usecases.FilterIndicators
import com.estebanposada.usecases.FindIndicatorByCode
import com.estebanposada.usecases.GetIndicators
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun indicatorRepoProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = IndicatorsRepository(localDataSource, remoteDataSource)

    @Provides
    fun getIndicatorProvider(repository: IndicatorsRepository): GetIndicators =
        GetIndicators(repository)

    @Provides
    fun findIndicatorByCodeProvider(repository: IndicatorsRepository): FindIndicatorByCode =
        FindIndicatorByCode(repository)

    @Provides
    fun filterIndicatorProvider(repository: IndicatorsRepository): FilterIndicators =
        FilterIndicators(repository)

    @Singleton
    @Provides
    fun dbProvider(app: Application) =
        Room.databaseBuilder(app, AppDatabase::class.java, "indicators-db").build()

    @Provides
    fun localDataSourceProvider(db: AppDatabase): LocalDataSource =
        RoomDataSource(db.indicatorDao())

    @Provides
    fun remoteDataSourceProvider(api: IndicatorApi): RemoteDataSource = RemoteDataSourceImpl(api)
}