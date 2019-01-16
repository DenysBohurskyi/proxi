package com.taxi.optio.profitable.proxi.main.domain

import com.taxi.optio.profitable.proxi.main.repository.RemoteRepository

class PriceListInteractorImpl(private val remoteRepository: RemoteRepository): PriceListInteractor {

    override fun getPriceList(): String? = remoteRepository.getRemoteData()

}