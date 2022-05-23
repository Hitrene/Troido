package com.example.myapplication.mapper

import com.example.myapplication.ui.PriceUIData
import com.example.myapplication.network.dto.PriceResponse

class PriceUIFromResponseImpl: PriceUIFromResponse {
    override fun map(response: PriceResponse): PriceUIData {
        return PriceUIData(response.bpi.USD.rateFloat, response.time.updated)
    }
}