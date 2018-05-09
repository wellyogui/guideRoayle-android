package com.example.well.clashroyaleguide.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class Clan (@SerializedName("donate")
            @Expose var donate: Donate,
            @SerializedName("request")
            @Expose var request: Request)

