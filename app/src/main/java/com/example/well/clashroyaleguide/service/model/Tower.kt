package com.example.well.clashroyaleguide.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class Tower(@SerializedName("hitPoint")
             @Expose open var hitPoint: Int,
                 @SerializedName("range")
             @Expose open var range: Int,
                 @SerializedName("damage")
             @Expose open var damage: Int,
                 @SerializedName("hitSpeed")
             @Expose open var hitSpeed: Int)
