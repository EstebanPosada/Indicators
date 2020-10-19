package com.estebanposada.indicadores.di

import android.app.Application
import com.estebanposada.indicadores.ui.detail.DetailFragment
import com.estebanposada.indicadores.ui.MainActivity
import com.estebanposada.indicadores.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }

    //val mainViewModel: MainViewModel

    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
    fun inject(fragment: DetailFragment)
}