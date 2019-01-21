package com.taxi.optio.profitable.proxi.main.domain.interactors

import com.taxi.optio.profitable.proxi.main.domain.entity.PlacesModel
import io.reactivex.Observable

interface PriceListInteractor {

    fun getPriceList(): String?

    fun findStartPlaces(startPointName: String): Observable<MutableList<PlacesModel>>

}