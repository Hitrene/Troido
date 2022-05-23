package com.example.myapplication.network.repo

import com.example.myapplication.network.dto.PriceResponse

interface PriceRepo {
    suspend fun getPrices() : PriceResponse?
}