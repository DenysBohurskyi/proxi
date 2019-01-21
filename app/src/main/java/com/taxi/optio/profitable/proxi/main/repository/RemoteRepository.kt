package com.taxi.optio.profitable.proxi.main.repository

import com.taxi.optio.profitable.proxi.main.domain.entity.PlacesModel
import io.reactivex.Observable

interface RemoteRepository {

    fun getRemoteData() : String?

    fun getPlaces(startPointAddress: String): Observable<MutableList<PlacesModel>>

}