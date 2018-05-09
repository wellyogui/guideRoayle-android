package com.example.well.clashroyaleguide.sync.response

import com.example.well.clashroyaleguide.model.Arena
import com.example.well.clashroyaleguide.sync.RetrofitClient

class ArenaData(): RetrofitClient() {
    private lateinit var responseData: List<Arena>
}