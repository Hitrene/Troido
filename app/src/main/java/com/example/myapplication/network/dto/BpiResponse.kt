package com.example.myapplication.network.dto

// TODO replace with map for the future support?
data class BpiResponse(
    val USD: PriceDataResponse,
    val GBP: PriceDataResponse,
    val EUR: PriceDataResponse
)