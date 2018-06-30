package com.example.well.clashroyaleguide.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Arena(
        @SerializedName("_id")
            @Expose var id: String,
        @SerializedName("idName")
        @Expose
        var idName: String,
        @SerializedName("number")
        @Expose
        var number: Int,
        @SerializedName("name")
        @Expose
        var name: String,
        @SerializedName("victoryGold")
        @Expose
        var victoryGold: Int,
        @SerializedName("minTrophies")
        @Expose
        var minTrophies:Int,
        @SerializedName("order")
        @Expose
        var order: Int,
        @SerializedName("__v")
        @Expose
        var v: Int,
        @SerializedName("leagues")
        @Expose
        var leagues: MutableList<String>,
        @SerializedName("cardUnlocks")
        @Expose
        var cardUnlocks: MutableList<String>,
        @SerializedName("chests")
        @Expose
        var chests: MutableList<String>,
        @SerializedName("clan")
        @Expose
        var clan: Clan)