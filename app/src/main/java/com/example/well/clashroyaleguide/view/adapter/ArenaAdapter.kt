package com.example.well.clashroyaleguide.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.model.Arena
import com.example.well.clashroyaleguide.model.Cards
import com.example.well.clashroyaleguide.presenter.CardPresenter
import com.example.well.clashroyaleguide.sync.contracts.CardListListener
import com.example.well.clashroyaleguide.view.adapter.ArenaAdapter.ArenaAdapterViewHolder
import kotlinx.android.synthetic.main.arena_list_row.view.*

internal const val imageURl = "http://www.clashapi.xyz/images/arenas/%s.png"

class ArenaAdapter(var arenaList: MutableList<Arena>?) : RecyclerView.Adapter<ArenaAdapterViewHolder>() {

    lateinit var context: Context
    lateinit var arena: Arena
    val cardPresenter = CardPresenter()
    lateinit var cards: MutableList<Cards>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArenaAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.arena_list_row, parent, false)

        context = parent.context

        return ArenaAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arenaList!!.size
    }

    override fun onBindViewHolder(holder: ArenaAdapterViewHolder, position: Int) {
        cardPresenter.getAllCards(object :CardListListener{
            override fun onCardListLoad(cardList: MutableList<Cards>) {
                cards = cardList
            }

            override fun onRequestStarted() {
                Log.d("Start", "Start")
            }

            override fun onRequestFinished() {
                Log.d("onRequestFinished", "finished")
            }

            override fun onError(error: Throwable) {
                Log.d("onError", error.message)
            }
        })
        holder.bind(arenaList?.get(position)!!, cards.get(position))
    }

    fun addAllArenas(arenas: MutableList<Arena>) {
        if (arenaList != null) {
            arenaList = arenas
        } else {
            arenaList
        }
    }

    class ArenaAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(arena: Arena, cards: Cards) = with(itemView){
            with(arena){
                arenaNameView.text = arena.name
                arenaNumberView.text = arena.number.toString()
                arenaTrophyView.text = arena.minTrophies.toString().plus("+")
                Glide.with(context)
                        .load(String.format(imageURl, arena.idName))
                        .into(arenaImageView)

            }

        }
    }
}