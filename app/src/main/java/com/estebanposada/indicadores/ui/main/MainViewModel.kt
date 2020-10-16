package com.estebanposada.indicadores.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estebanposada.indicadores.data.database.Indicator
import com.estebanposada.indicadores.service.repository.MainRepository
import com.estebanposada.indicadores.usecases.GetIndicators
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getIndicators: GetIndicators) : ViewModel() {


    private val _indicators = MutableLiveData<Indicator>()
    val indicators: LiveData<Indicator>
        get() = _indicators

    fun fetchData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = getIndicators.invoke()
                _indicators.postValue(data)
            }
        }
    }

}