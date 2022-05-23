package com.example.myapplication.mapper

import com.example.myapplication.network.dto.PriceResponse
import com.example.myapplication.ui.PriceUIData

interface PriceUIFromResponse {
    fun map(response: PriceResponse): PriceUIData
}