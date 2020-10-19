package com.estebanposada.indicadores

import android.app.Application
import com.estebanposada.indicadores.di.AppComponent
import com.estebanposada.indicadores.di.DaggerAppComponent

open class App : Application() {

    val appComponent: AppComponent by lazy { initializeComponent() }

    open fun initializeComponent(): AppComponent =
        DaggerAppComponent.factory().create(this)
}