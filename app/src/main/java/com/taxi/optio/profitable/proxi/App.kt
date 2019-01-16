package com.taxi.optio.profitable.proxi

import android.app.Application
import com.taxi.optio.profitable.proxi.di.*
import org.koin.android.ext.android.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, viewModelModule, interactorModule, repositoryModule, networkModule))

    }
}

