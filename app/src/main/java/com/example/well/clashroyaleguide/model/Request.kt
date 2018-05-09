package com.example.well.clashroyaleguide.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 21/02/2018.
 */

class Request (@SerializedName("common")
               @Expose private var common: Int,
               @SerializedName("rare")
               @Expose private var rare: Int)
