package com.example.myapplication.network.dto

data class PriceResponse(
    val time: PriceTimeResponse,
    val disclaimer: String,
    val chartName: String,
    val bpi: BpiResponse
)