package com.estebanposada.indicadores.di

import com.estebanposada.indicadores.data.service.IndicatorApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideIndicatorsService(client: OkHttpClient): IndicatorApi = Retrofit.Builder()
        .baseUrl("https://www.mindicador.cl/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IndicatorApi::class.java)

    @Provides
    fun provideClient(): OkHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }
}