package com.example.well.clashroyaleguide.service.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

open class Card(@SerializedName("id")
                val id: String,
                @SerializedName("idName")
                val idName: String,
                @SerializedName("rarity")
                val rarity: String,
                @SerializedName("type")
                val type: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("description")
                val descritpion: String,
                @SerializedName("elixirCost")
                val elixirCost: Int,
                @SerializedName("arena")
                val arena: Int,
                @SerializedName("order")
                val order: Int,
                @SerializedName("v")
                val v: Int, // ????????
                @SerializedName("cards")
                open val cards: MutableList<String>,
        //Belong to Chests
                @SerializedName("number")
                val number: Int,
                @SerializedName("minLegendary")
                val minLegendary: Int,
                @SerializedName("minEpic")
                val minEpic: Int,
                @SerializedName("minRare")
                val minRare: Int,
                @SerializedName("minComun")
                val minComun: Int) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.createStringArrayList(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(idName)
        writeString(rarity)
        writeString(type)
        writeString(name)
        writeString(descritpion)
        writeInt(elixirCost)
        writeInt(arena)
        writeInt(order)
        writeInt(v)
        writeStringList(cards)
        writeInt(number)
        writeInt(minLegendary)
        writeInt(minEpic)
        writeInt(minRare)
        writeInt(minComun)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Card> = object : Parcelable.Creator<Card> {
            override fun createFromParcel(source: Parcel): Card = Card(source)
            override fun newArray(size: Int): Array<Card?> = arrayOfNulls(size)
        }
    }
}
