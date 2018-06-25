package com.example.well.clashroyaleguide.Service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 02/12/2017.
 */

class Leagues (@SerializedName("id")
               @Expose var id: String,
               @SerializedName("id")
               @Expose var idName: String,
               @SerializedName("id")
               @Expose var number: Int,
               @SerializedName("id")
               @Expose var name: String,
               @SerializedName("id")
               @Expose var victoryGold: Int,
               @SerializedName("id")
               @Expose var minTrophies: Int,
               @SerializedName("id")
               @Expose var leagueSeasionReset: Int,
               @SerializedName("id")
               @Expose var arena: Arena,
               @SerializedName("id")
               @Expose var order: Int,
               @SerializedName("id")
               @Expose var v: Int, //????????
               @SerializedName("id")
               @Expose var chests: Chests,
               @SerializedName("id")
               @Expose var leagues: MutableList<String>)

