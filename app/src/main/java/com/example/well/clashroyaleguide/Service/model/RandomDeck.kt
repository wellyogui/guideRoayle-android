package com.example.well.clashroyaleguide.Service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wellingtonyogui on 02/12/2017.
 */

class RandomDeck (@SerializedName("cards")
                  @Expose var cardsRandom: MutableList<String>)

    // Tratar da mesma forma que o Cards



