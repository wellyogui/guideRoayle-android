package com.example.well.clashroyaleguide.Service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class Unlock (@SerializedName("gemCost")
              @Expose var gemCost: Int,
              @SerializedName("time")
              @Expose var time: Int)

