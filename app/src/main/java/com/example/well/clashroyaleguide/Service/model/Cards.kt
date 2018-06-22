package com.example.well.clashroyaleguide.Service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class Cards (@SerializedName("id")
             @Expose var id : String,
                  @SerializedName("idName")
             @Expose var idName: String,
                  @SerializedName("rarity")
             @Expose var rarity: String,
                  @SerializedName("type")
             @Expose var type: String,
                  @SerializedName("name")
             @Expose var name: String,
                  @SerializedName("description")
             @Expose var descritpion: String,
                  @SerializedName("elixirCost")
             @Expose var elixirCost: Int,
                  @SerializedName("arena")
             @Expose var arena: Int,
                  @SerializedName("order")
             @Expose var order: Int,
                  @SerializedName("v")
             @Expose var v: Int, // ????????
                  @SerializedName("cards")
             @Expose open var cards: MutableList<String>,
             //Belong to Chests
                  @SerializedName("number")
             @Expose var number: Int,
                  @SerializedName("minLegendary")
             @Expose var minLegendary: Int,
                  @SerializedName("minEpic")
             @Expose var minEpic: Int,
                  @SerializedName("minRare")
             @Expose var minRare: Int,
                  @SerializedName("minComun")
             @Expose var minComun: Int) {
}
