package com.estebanposada.indicadores.di

import com.estebanposada.indicadores.ui.main.MainViewModel
import com.estebanposada.usecases.FilterIndicators
import com.estebanposada.usecases.FindIndicatorByCode
import com.estebanposada.usecases.GetIndicators
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelsModule {

    @Singleton
    @Provides
    fun mainViewModelProvider(
        getIndicators: GetIndicators,
        findIndicatorByCode: FindIndicatorByCode,
        filterIndicators: FilterIndicators
    ) = MainViewModel(getIndicators, findIndicatorByCode, filterIndicators)
}