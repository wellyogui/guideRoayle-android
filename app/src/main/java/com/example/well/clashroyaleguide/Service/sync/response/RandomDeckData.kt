package com.example.well.clashroyaleguide.Service.sync.response

import com.example.well.clashroyaleguide.Service.model.RandomDeck
import com.example.well.clashroyaleguide.Service.RetrofitClient

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class RandomDeckData : RetrofitClient() {
    lateinit var responseData: RandomDeck
}
