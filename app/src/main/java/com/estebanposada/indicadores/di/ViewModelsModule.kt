package com.estebanposada.indicadores.di

import com.estebanposada.indicadores.service.repository.MainRepository
import com.estebanposada.indicadores.ui.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    fun mainViewModel(repository: MainRepository) = MainViewModel(repository)
}