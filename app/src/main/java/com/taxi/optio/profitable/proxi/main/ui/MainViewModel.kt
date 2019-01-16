package com.taxi.optio.profitable.proxi.main.ui

import androidx.lifecycle.ViewModel
import com.taxi.optio.profitable.proxi.main.domain.PriceListInteractor
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MainViewModel: ViewModel(), KoinComponent {

    val interactor by inject<PriceListInteractor>()

    val stringList = interactor.getPriceList()


}
