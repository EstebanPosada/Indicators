package com.estebanposada.indicadores.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estebanposada.domain.IndicatorDetails
import com.estebanposada.usecases.FilterIndicators
import com.estebanposada.usecases.FindIndicatorByCode
import com.estebanposada.usecases.GetIndicators
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getIndicators: GetIndicators,
    private val findIndicatorByCode: FindIndicatorByCode,
    private val filterIndicators: FilterIndicators
) : ViewModel() {

    private val _indicators = MutableLiveData<List<IndicatorDetails>>()
    val indicators: LiveData<List<IndicatorDetails>>
        get() = _indicators

    private val _detail = MutableLiveData<IndicatorDetails>(
    )
    val detail: LiveData<IndicatorDetails>
        get() = _detail

    fun fetchIndicators() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = getIndicators.invoke()
                _indicators.postValue(data)
            }
        }
    }

    fun filterIndicators(filter: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val filtered = filterIndicators.invoke(filter)
                _indicators.postValue(filtered)
            }
        }
    }

    fun findIndicator(code: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = findIndicatorByCode.invoke(code)
                _detail.postValue(data)
            }
        }
    }


}