package com.example.well.clashroyaleguide.Service.sync.contracts

import com.example.well.clashroyaleguide.Service.model.Cards

/**
 * Created by wellingtonyogui on 12/06/2018 for guideRoayle-android.
 */
interface CardListListener :BaseListener {

    fun onCardListLoad(cardList: MutableList<Cards>)

}