package com.example.well.clashroyaleguide.sync.response

import com.example.well.clashroyaleguide.model.Leagues
import com.example.well.clashroyaleguide.sync.RetrofitClient

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class LeaguesData : RetrofitClient() {
    lateinit var responseData: Leagues
}
