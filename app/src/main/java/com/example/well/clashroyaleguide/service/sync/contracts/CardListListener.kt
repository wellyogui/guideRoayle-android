package com.example.well.clashroyaleguide.service.sync.contracts

import com.example.well.clashroyaleguide.service.model.Card

/**
 * Created by wellingtonyogui on 12/06/2018 for guideRoayle-android.
 */
interface CardListListener :BaseListener {

    fun onCardListLoad(cardList: MutableList<Card>)

}