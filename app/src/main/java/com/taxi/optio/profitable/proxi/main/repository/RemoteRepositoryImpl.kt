package com.taxi.optio.profitable.proxi.main.repository

import com.taxi.optio.profitable.proxi.utils.RestService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RemoteRepositoryImpl(private var restApi: RestService): RemoteRepository {

    override fun getRemoteData(): String? = callApi()

    private fun callApi(): String? {

        var resp: String? = null

        restApi.getPlaces("http://ip.jsontest.com/").enqueue(object: Callback,
            retrofit2.Callback<MutableList<String?>> {
            override fun onFailure(call: Call<MutableList<String?>>, t: Throwable?) {
                resp = t?.localizedMessage
            }

            override fun onResponse(call: Call<MutableList<String?>>, response: Response<MutableList<String?>>) {
                if (response.isSuccessful && response.body() != null) {
                    resp = response.body().toString()
                } else {
                    resp = "chet pzdc"
                }
            }

        })

        return resp

    }




}