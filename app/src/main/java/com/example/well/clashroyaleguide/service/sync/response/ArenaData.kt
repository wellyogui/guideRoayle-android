package com.example.well.clashroyaleguide.service.sync.response

import com.example.well.clashroyaleguide.service.RetrofitClient
import com.example.well.clashroyaleguide.service.model.Arena

class ArenaData(): RetrofitClient() {
    private lateinit var responseData: List<Arena>
}