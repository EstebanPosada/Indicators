package com.estebanposada.indicadores.di

import com.estebanposada.indicadores.ui.main.MainViewModel
import com.estebanposada.indicadores.usecases.GetIndicators
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelsModule {

    @Singleton
    @Provides
    fun mainViewModelProvider(getIndicators: GetIndicators) = MainViewModel(getIndicators)
}