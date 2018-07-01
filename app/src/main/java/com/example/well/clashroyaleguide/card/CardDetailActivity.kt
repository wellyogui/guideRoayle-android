package com.example.well.clashroyaleguide.card

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.fastshop.ecommerce.refactor.util.requiredBundleNotFound
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.service.model.Card
import kotlinx.android.synthetic.main.activity_card_detail.*
import org.jetbrains.anko.startActivity


/**
 * Created by wellingtonyogui on 29/06/2018 for guideRoayle-android.
 */

private const val EXTRA_CARD = "EXTRA_CARD"

class CardDetailActivity: AppCompatActivity() {

    private lateinit var card: Card

    companion object {
        @JvmStatic
        fun startActivity(context: Context, card: Card) {
            context.startActivity<CardDetailActivity>(EXTRA_CARD to card)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)
        initData()
        cardNameView.text = card.name
    }

    private fun init(){

    }

    private fun initData() {
        with(intent.extras) {
            getParcelable<Card>(EXTRA_CARD)?.let {
                card = it
            } ?: run {
                requiredBundleNotFound(EXTRA_CARD)
            }
        }
    }

}