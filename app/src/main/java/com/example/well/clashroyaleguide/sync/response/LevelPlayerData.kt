package com.example.well.clashroyaleguide.sync.response

import com.example.well.clashroyaleguide.model.LevelPlayer
import com.example.well.clashroyaleguide.sync.RetrofitClient

/**
 * Created by wellingtonyogui on 03/02/2018.
 */

class LevelPlayerData : RetrofitClient() {
    lateinit var responseData: LevelPlayer
}
