package com.estebanposada.indicadores.di

import android.content.Context
import com.estebanposada.indicadores.ui.detail.DetailFragment
import com.estebanposada.indicadores.ui.main.MainActivity
import com.estebanposada.indicadores.ui.main.MainFragment
import com.estebanposada.indicadores.ui.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    //val mainViewModel: MainViewModel

    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
    fun inject(fragment: DetailFragment)
}