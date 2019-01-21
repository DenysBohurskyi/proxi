package com.taxi.optio.profitable.proxi.utils.newtwork

import com.taxi.optio.profitable.proxi.main.domain.entity.PlacesModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RestService {

//    https://www.uber.com/api/autocomplete-address?query=%D0%93%D0%BB%D1%83%D1%88%D0%BA%D0%BE%D0%B2%D0%B0%205

    @GET
    fun getPlaces(@Url url: String): Observable<MutableList<PlacesModel>>

    @GET
    fun getPriceList(@Url url: String): Call<MutableList<String?>>

}