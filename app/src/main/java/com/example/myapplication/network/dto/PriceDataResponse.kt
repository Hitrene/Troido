package com.example.myapplication.network.dto

import com.google.gson.annotations.SerializedName

data class PriceDataResponse(
    val code: String,
    val symbol: String,
    val rate: String,
    val description: String,
    @SerializedName("rate_float")
    val rateFloat: Float
)