package com.example.well.clashroyaleguide.Cards

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.Service.model.Cards
import kotlinx.android.synthetic.main.card_list_row.view.*

/**
 * Created by wellingtonyogui on 21/02/2018.
 */

internal const val IMAGECARD ="http://www.clashapi.xyz/images/cards/"

class CardAdapter(var cardList: MutableList<Cards>?): RecyclerView.Adapter<CardAdapter.CardAdapterViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_row, parent, false)

        context = parent.context

        return CardAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardList!!.size
    }

    override fun onBindViewHolder(holder: CardAdapterViewHolder, position: Int) {
        val card = cardList?.get(position)

        holder.cardName.text = card?.name

        Glide.with(context)
                .load(IMAGECARD.plus(card?.idName).plus(".png"))
                .into(holder.cardImage)
    }


    fun addAllCards(cards: MutableList<Cards>) {
        if (cardList != null) {
            cardList = cards
        } else {
            cardList
        }
    }

    class CardAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardName = itemView.cardNameView
        val cardImage = itemView.cardImageView
    }
}
