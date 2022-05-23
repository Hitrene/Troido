package com.example.myapplication.network

import com.example.myapplication.network.dto.PriceResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v1/bpi/currentprice.json")
    suspend fun getCurrencies(): PriceResponse
}