package com.example.well.clashroyaleguide.Cards

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.Service.model.Cards
import kotlinx.android.synthetic.main.card_list_row.view.*

/**
 * Created by wellingtonyogui on 21/02/2018.
 */

internal const val IMAGECARD ="http://www.clashapi.xyz/images/cards/"
internal const val RARE = "Rare"
internal const val EPIC = "Epic"

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

        Glide.with(context)
                .load(IMAGECARD.plus(card?.idName).plus(".png"))
                .into(holder.cardImage)

        when(card?.rarity){
            RARE -> {
                holder.cardImage = ImageView(context).apply {
                    holder.cardImage.background = ResourcesCompat.getDrawable(resources, R.drawable.rare_frame_layout, null)
                }
            }

            EPIC -> {
                holder.cardImage = ImageView(context).apply {
                    holder.cardImage.background = ResourcesCompat.getDrawable(resources, R.drawable.epic_frame_layout, null)
                }
            }
        }



    }


    fun addAllCards(cards: MutableList<Cards>) {
        if (cardList != null) {
            cardList = cards
        } else {
            cardList
        }
    }

    class CardAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cardImage = itemView.cardImageView
    }
}
