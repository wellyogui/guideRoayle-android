package com.example.well.clashroyaleguide.card


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.service.model.Cards
import com.example.well.clashroyaleguide.service.sync.contracts.CardListListener
import kotlinx.android.synthetic.main.fragment_card.*
import kotlinx.android.synthetic.main.fragment_card.view.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */

internal const val RARITY = "RARITY"
internal const val DESC_RARITY = "DESC_RARITY"
internal const val ARENA = "ARENA"
internal const val ELIXIR = "ELIXIR"

class CardFragment: Fragment() {

    lateinit var cardAdapter: CardAdapter
    lateinit var cards: MutableList<Cards>
    var cardPresenter = CardPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)

        val linearLayout = GridLayoutManager(context,4)
        view.cardListView.layoutManager = linearLayout

        view.orderView.setOnClickListener { sortBy(ELIXIR) }
        getAllCards()

        return view
    }

    private fun sortBy(sortBy: String){
        when (sortBy) {
            RARITY -> {
                view?.orderView?.text = RARITY
                val sorted = cards.groupBy { (it.rarity) }
                cards.clear()
                sorted.values.forEach {
                    cards.addAll(it)
                }
                updateList()
            }

            DESC_RARITY -> {
                view?.orderView?.text = DESC_RARITY
                val sorted = cards.groupBy { (it.rarity) }
                cards.clear()
                sorted.values.reversed().forEach {
                    cards.addAll(it)
                }
                updateList()
            }

            ARENA -> {
                view?.orderView?.text = ARENA
                val sorted = cards.groupBy { (it.arena) }
                cards.clear()
                sorted.values.forEach {
                    cards.addAll(it)
                }
                updateList()
            }

            ELIXIR -> {
                view?.orderView?.text = ELIXIR
                val sorted = cards.groupBy { (it.elixirCost) }
                val orded = TreeMap(sorted)
                cards.clear()
                orded.values.forEach {
                    cards.addAll(it)
                }
                updateList()
            }
        }
    }

    private fun updateList(){
        cardAdapter.notifyDataSetChanged()
        cardListView.adapter = cardAdapter
    }

    private fun getAllCards(){
        cardPresenter.getAllCards(object : CardListListener {
            override fun onCardListLoad(cardList: MutableList<Cards>) {
                cards = cardList

                cardAdapter = CardAdapter(cards)
                cardAdapter.addAllCards(cards)
                cardListView.adapter = cardAdapter
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
        }

        )
    }

}
