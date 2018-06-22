package com.example.well.clashroyaleguide.sync

import com.example.well.clashroyaleguide.model.Arena
import com.example.well.clashroyaleguide.model.Cards
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ClashApi {

    @GET("/api/arenas/")
    fun getAllArenas(): Observable<MutableList<Arena>>

    @GET("/arenas/{id}")
    fun getArena(@Path("id")id: String)

    @GET("/api/cards/")
    fun getAllCards(): Observable<MutableList<Cards>>
}