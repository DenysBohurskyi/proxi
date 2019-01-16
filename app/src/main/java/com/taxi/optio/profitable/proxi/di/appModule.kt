package com.taxi.optio.profitable.proxi.di

import com.taxi.optio.profitable.proxi.ui.main.MainViewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val appModule: Module = module {

}

val viewModelModule: Module = module {

    viewModel { MainViewModel(PostTaxiListModel(taxiPostsList = get())) }

}

val useCaseModule: Module = module {

    factory { TaxiPostsUseCase(taxiPostRepository = get()) }

}

val repositoryModule: Module = module {

    single { TaxiPostRepositoryImpl(postsApi = get()) as TaxiPostRepository }

}

val networkModule: Module = module {

    single { New }

}