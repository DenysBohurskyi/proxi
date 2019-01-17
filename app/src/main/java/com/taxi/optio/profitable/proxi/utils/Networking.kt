package com.taxi.optio.profitable.proxi.utils

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Networking(private val gson: Gson, private val okHttpClient: OkHttpClient.Builder) {

    fun <T> create(serviceClass: Class<T>): T {
        val client = okHttpClient.build()
        return create(serviceClass, client)
    }

    private fun <T> create(serviceClass: Class<T>, okHttpClient: OkHttpClient): T {
        val builder = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(
                GsonConverterFactory.create(gson))
        val retrofit = builder.client(okHttpClient).build()
        return retrofit.create(serviceClass)
    }

}