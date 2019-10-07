package com.example.well.clashroyaleguide.service.sync.response

import com.example.well.clashroyaleguide.service.model.Chest
import com.example.well.clashroyaleguide.service.RetrofitClient

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class ChestsData : RetrofitClient() {
    lateinit var responseData: Chest
}
