package com.taxi.optio.profitable.proxi.main.repository

import com.taxi.optio.profitable.proxi.utils.Networking

class RemoteRepositoryImpl(): RemoteRepository {

    override fun getRemoteData(): String? = "result from repo"

}