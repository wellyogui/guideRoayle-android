package com.example.well.clashroyaleguide.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class Gold (@SerializedName("min")
            @Expose var min: Int,
            @SerializedName("max")
            @Expose var max: Int )
