package com.example.well.clashroyaleguide.Service.sync.response

import com.example.well.clashroyaleguide.Service.RetrofitClient
import com.example.well.clashroyaleguide.Service.model.Arena

class ArenaData(): RetrofitClient() {
    private lateinit var responseData: List<Arena>
}