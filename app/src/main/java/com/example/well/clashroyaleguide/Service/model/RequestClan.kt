package com.example.well.clashroyaleguide.Service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class RequestClan (@SerializedName("common")
                   @Expose var common: Int,
                   @SerializedName("rare")
                   @Expose var rare: Int)