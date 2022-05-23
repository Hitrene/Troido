package com.example.myapplication

import android.app.Application
import com.example.myapplication.network.networkModule
import com.example.myapplication.network.uiModule
import com.example.myapplication.network.viewModelModule
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(networkModule, viewModelModule, uiModule)
        }
    }
}