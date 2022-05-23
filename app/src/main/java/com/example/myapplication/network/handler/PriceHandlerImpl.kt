package com.example.myapplication.network.handler

import com.example.myapplication.mapper.PriceUIFromResponse
import com.example.myapplication.network.dto.PriceResponse
import com.example.myapplication.network.repo.PriceRepo
import com.example.myapplication.ui.MainViewModel
import com.example.myapplication.ui.PriceUIData

class PriceHandlerImpl(private val repo: PriceRepo, private val priceUIFromResponse: PriceUIFromResponse): PriceHandler {
    override suspend fun requestPrices(currentItems: List<PriceUIData>): List<PriceUIData>? {
        val result = repo.getPrices()

        return handleResult(currentItems, result)
    }

    private fun handleResult(currentItems: List<PriceUIData>, result: PriceResponse?): List<PriceUIData>? {
        if (result == null) return null

        val mappedResult = priceUIFromResponse.map(result)
        return currentItems.toMutableList().apply {
            if (currentItems.size == MainViewModel.MAX_SIZE) {
                removeFirst()
            } else {
                add(mappedResult)
            }
        }
    }
}