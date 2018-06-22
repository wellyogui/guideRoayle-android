package com.example.well.clashroyaleguide.Service.sync.response

import com.example.well.clashroyaleguide.Service.model.Leagues
import com.example.well.clashroyaleguide.Service.RetrofitClient

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class LeaguesData : RetrofitClient() {
    lateinit var responseData: Leagues
}
