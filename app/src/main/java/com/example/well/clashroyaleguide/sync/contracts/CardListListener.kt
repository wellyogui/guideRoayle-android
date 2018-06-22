package com.example.well.clashroyaleguide.sync.contracts

import com.example.well.clashroyaleguide.model.Cards

/**
 * Created by wellingtonyogui on 12/06/2018 for guideRoayle-android.
 */
interface CardListListener :BaseListener {

    fun onCardListLoad(cardList: MutableList<Cards>)

}