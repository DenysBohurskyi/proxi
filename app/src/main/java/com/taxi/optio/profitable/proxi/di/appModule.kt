package com.taxi.optio.profitable.proxi.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.taxi.optio.profitable.proxi.BuildConfig
import com.taxi.optio.profitable.proxi.main.domain.interactors.PriceListInteractor
import com.taxi.optio.profitable.proxi.main.domain.interactors.PriceListInteractorImpl
import com.taxi.optio.profitable.proxi.main.repository.RemoteRepository
import com.taxi.optio.profitable.proxi.main.repository.RemoteRepositoryImpl
import com.taxi.optio.profitable.proxi.main.ui.MainViewModel
import com.taxi.optio.profitable.proxi.utils.newtwork.Networking
import com.taxi.optio.profitable.proxi.utils.newtwork.RestService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import java.util.concurrent.TimeUnit

val appModulec: Module = module {

}

val viewModelModule: Module = module {
    viewModel { MainViewModel() }
}

val interactorModule: Module = module {

    factory<PriceListInteractor>{
        PriceListInteractorImpl(
            get()
        )
    }
}

val repositoryModule: Module = module {

    factory<RemoteRepository>{ RemoteRepositoryImpl(get())}

}

val networkModule: Module = module {

    single{ Networking(get(), get())
        .create(RestService::class.java) }

    single {
        GsonBuilder()
            .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    single {
        val logger = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logger.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logger.level = HttpLoggingInterceptor.Level.NONE
        }
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logger)
    }

}