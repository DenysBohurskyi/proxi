package com.taxi.optio.profitable.proxi.main.domain.interactors

import com.taxi.optio.profitable.proxi.main.domain.entity.PlacesModel
import com.taxi.optio.profitable.proxi.main.repository.RemoteRepository
import io.reactivex.Observable

class PriceListInteractorImpl(private val remoteRepository: RemoteRepository):
    PriceListInteractor {

    override fun findStartPlaces(startPointName: String): Observable<MutableList<PlacesModel>> = remoteRepository.getPlaces(startPointName)

    override fun getPriceList(): String? = remoteRepository.getRemoteData()

}