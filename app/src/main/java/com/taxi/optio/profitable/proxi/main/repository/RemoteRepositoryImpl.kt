package com.taxi.optio.profitable.proxi.main.repository

import com.taxi.optio.profitable.proxi.main.domain.entity.PlacesModel
import com.taxi.optio.profitable.proxi.utils.newtwork.RestService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RemoteRepositoryImpl(private var restApi: RestService) : RemoteRepository {

    override fun getRemoteData(): String? = callApi()

    private fun callApi(): String? {

//        var resp: String? = null
//
//        restApi.getPlaces("http://ip.jsontest.com/").enqueue(object: Callback,
//            retrofit2.Callback<MutableList<String?>> {
//            override fun onFailure(call: Call<MutableList<String?>>, t: Throwable?) {
//                resp = t?.localizedMessage
//            }
//
//            override fun onResponse(call: Call<MutableList<String?>>, response: Response<MutableList<String?>>) {
//                resp = if (response.isSuccessful && response.body() != null) {
//                    response.body().toString()
//                } else {
//                    "chet"
//                }
//            }
//
//        })
//
//        return resp
        return "test"
    }

    override fun getPlaces(startPointAddress: String): Observable<MutableList<PlacesModel>> =
        restApi.getPlaces("https://www.uber.com/api/autocomplete-address?query=$startPointAddress")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}