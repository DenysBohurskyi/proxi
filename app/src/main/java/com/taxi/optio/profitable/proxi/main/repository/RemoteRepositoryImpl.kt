package com.taxi.optio.profitable.proxi.main.repository

import com.taxi.optio.profitable.proxi.utils.Networking

class RemoteRepositoryImpl(private var networking: Networking): RemoteRepository {

    override fun getRemoteData(): String? = "result from repo"

}