package com.example.myapplication.network.handler

import com.example.myapplication.ui.PriceUIData

interface PriceHandler {
    suspend fun requestPrices(currentItems: List<PriceUIData>): List<PriceUIData>?
}