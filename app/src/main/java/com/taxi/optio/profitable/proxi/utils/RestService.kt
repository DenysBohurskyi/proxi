package com.taxi.optio.profitable.proxi.utils

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RestService {

    @GET
    fun getPlaces(@Url url: String): Call<MutableList<String?>>

    @GET
    fun getPriceList(@Url url: String): Call<MutableList<String?>>

}