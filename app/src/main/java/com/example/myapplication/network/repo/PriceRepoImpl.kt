package com.example.myapplication.network.repo

import android.util.Log
import com.example.myapplication.network.ApiService
import com.example.myapplication.network.dto.PriceResponse
import java.lang.Exception

class PriceRepoImpl(private val apiService: ApiService): PriceRepo {
    override suspend fun getPrices(): PriceResponse? {
        var result: PriceResponse? = null

        try {
            result = apiService.getCurrencies()
        } catch (e: Exception) {
            Log.d("+++", "Error")
        }

        return result
    }
}