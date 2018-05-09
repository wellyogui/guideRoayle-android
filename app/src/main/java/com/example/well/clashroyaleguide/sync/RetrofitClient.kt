package com.example.well.clashroyaleguide.sync

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitClient {

    private val SERVER_URL: String = "http://www.clashapi.xyz/api/"

    var mClashApi: ClashApi

    init{
        mClashApi = Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ClashApi::class.java)
    }

    fun getClashApi(): ClashApi {
        return mClashApi
    }
}