package com.example.well.clashroyaleguide.service.sync.response

import com.example.well.clashroyaleguide.service.RetrofitClient
import com.example.well.clashroyaleguide.service.model.Card

class CardsData: RetrofitClient() {
    private lateinit var responseData: List<Card>
}