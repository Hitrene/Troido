package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.mapper.PriceUIFromResponse
import com.example.myapplication.network.dto.PriceResponse
import com.example.myapplication.network.handler.PriceHandler
import com.example.myapplication.network.repo.PriceRepo
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val priceHandler: PriceHandler) : ViewModel() {
    private val _priceData: MutableLiveData<List<PriceUIData>> = MutableLiveData(emptyList())
    val priceData: LiveData<List<PriceUIData>>
        get() = _priceData

    private var job: Job? = null

    fun receiveData() {
        if (job != null) return

        job = viewModelScope.launch {
            val result = priceHandler.requestPrices(_priceData.value ?: emptyList())
            _priceData.value = result

            delay(TIMEOUT)
            job = null
            receiveData()
        }
    }



    companion object {
        const val TIMEOUT = 5000L
        const val MAX_SIZE = 50
    }
}