package com.taxi.optio.profitable.proxi.main.ui

import com.taxi.optio.profitable.proxi.main.domain.PriceListInteractor

class MainViewModel {


    constructor(interactor: PriceListInteractor) : ViewModel(){

    }

    val stringList = interactor.getPriceList()

}
