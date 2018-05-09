package com.example.well.clashroyaleguide.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 02/12/2017.
 */

class LevelPlayer (@SerializedName("id")
                   @Expose var id: String,
                   @SerializedName("idName")
                   @Expose var idName: String?,
                   @SerializedName("level")
                   @Expose var level: Int,
                   @SerializedName("maxExp")
                   @Expose var maxExp: Int,
                   @SerializedName("order")
                   @Expose var order: Int,
                   @SerializedName("v")
                   @Expose var v: Int, // ??????????
                   @SerializedName("arenaTowers")
                   @Expose var arenaTowers: MutableList<ArenaTowers>,
                   @SerializedName("levelPlayer")
                   @Expose var levelPlayer: MutableList<String>)

