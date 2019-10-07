package com.example.well.clashroyaleguide.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArenaTower(@SerializedName("hitPoint")
                  @Expose override var hitPoint: Int,
                 @SerializedName("range")
                  @Expose override var range: Int,
                 @SerializedName("damage")
                  @Expose override var damage: Int,
                 @SerializedName("hitSpeed")
                  @Expose override var hitSpeed: Int) : Tower(hitPoint, range, damage, hitSpeed)
