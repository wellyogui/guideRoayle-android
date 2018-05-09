package com.example.well.clashroyaleguide.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class KingTower(@SerializedName("hitPoint")
                @Expose override var hitPoint: Int,
                @SerializedName("range")
                @Expose override var range: Int,
                @SerializedName("damage")
                @Expose override var damage: Int,
                @SerializedName("hitSpeed")
                @Expose override var hitSpeed: Int) : Towers(hitPoint, range, damage, hitSpeed)
