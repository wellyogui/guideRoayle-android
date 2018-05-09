package com.example.well.clashroyaleguide.sync.response

import com.example.well.clashroyaleguide.model.Cards
import com.example.well.clashroyaleguide.sync.RetrofitClient

class CardsData: RetrofitClient() {
    private lateinit var responseData: List<Cards>
}