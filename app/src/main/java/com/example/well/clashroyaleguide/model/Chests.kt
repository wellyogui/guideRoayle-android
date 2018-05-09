package com.example.well.clashroyaleguide.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Chests (@SerializedName("id")
              @Expose var id : String,
              @SerializedName("idName")
              @Expose var idName: String,
              @SerializedName("name")
              @Expose var name: String,
              @SerializedName("description")
              @Expose var descritpion: String,
              @SerializedName("order")
              @Expose var order: Int,
              @SerializedName("v")
              @Expose var v: Int, //???????
              @SerializedName("gemCost")
              @Expose var gemCost: Int,
              @SerializedName("Arena")
              @Expose var arena: Arena,
              @SerializedName("unlocks")
              @Expose var unlocks: MutableList<Unlock>,
              @SerializedName("gold")
              @Expose var gold: MutableList<Gold>,
              @SerializedName("cards")
              @Expose var cards: MutableList<Cards>)