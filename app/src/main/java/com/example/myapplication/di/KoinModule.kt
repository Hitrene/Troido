package com.example.myapplication.network

import com.example.myapplication.mapper.PriceUIFromResponse
import com.example.myapplication.mapper.PriceUIFromResponseImpl
import com.example.myapplication.network.handler.PriceHandler
import com.example.myapplication.network.handler.PriceHandlerImpl
import com.example.myapplication.network.repo.PriceRepo
import com.example.myapplication.network.repo.PriceRepoImpl
import com.example.myapplication.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitBuilder.getRetrofit() }
    factory { RetrofitBuilder.getApiService(get()) }
    single<PriceRepo> { PriceRepoImpl(get()) }
    single<PriceHandler> { PriceHandlerImpl(get(), get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val uiModule = module {
    single<PriceUIFromResponse> { PriceUIFromResponseImpl() }
}