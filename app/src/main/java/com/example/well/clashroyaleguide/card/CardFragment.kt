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
internal var ORDER_BY = 0

class CardFragment: Fragment() {
    lateinit var cardAdapter: CardAdapter
    lateinit var cards: MutableList<Cards>
    private var cardPresenter = CardPresenter()
    private val orderList = arrayListOf("Por raridade", "Por raridade (Descrescente)", "Por arena", "Por elixir")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)

        val linearLayout = GridLayoutManager(context,4)
        view.cardListView.layoutManager = linearLayout

        view?.orderView?.text = orderList[0]


        view.orderView.setOnClickListener {
            when (ORDER_BY) {
                -1 -> {
                    sortBy(RARITY)
                    ORDER_BY += 1
                }

                0 -> {
                    sortBy(DESC_RARITY)
                    ORDER_BY += 1
                }

                1 -> {
                    sortBy(ARENA)
                    ORDER_BY += 1
                }

                2 -> {
                    sortBy(ELIXIR)
                    ORDER_BY = -1
                }
            }
        }

        getAllCards()

        return view
    }



    private fun sortBy(sortBy: String){
        when (sortBy) {
            RARITY -> {
                view?.orderView?.text = orderList[0]
                sortByRarity(cards)
            }

            DESC_RARITY -> {
                view?.orderView?.text = orderList[1]
                sortByRarityDesc(cards)
            }

            ARENA -> {
                view?.orderView?.text = orderList[2]
                sortByArena(cards)
            }

            ELIXIR -> {
                view?.orderView?.text = orderList[3]
                sortByElixir(cards)
            }
        }

        updateList()
    }

    private fun updateList(){
        cardAdapter.notifyDataSetChanged()
        cardListView.adapter = cardAdapter
    }

    private fun sortByRarity(listCard: MutableList<Cards>){
        val sorted = listCard.groupBy { (it.rarity) }
        if (sorted.keys.first() != "Common") {
            getAllCards()
        } else {
            listCard.clear()
            sorted.values.forEach {
                listCard.addAll(it)
            }
        }
    }


    private fun sortByRarityDesc(listCard: MutableList<Cards>){
        val sorted = listCard.groupBy { (it.rarity) }
        listCard.clear()
        sorted.values.reversed().forEach {
            listCard.addAll(it)
        }
    }

    private fun sortByArena(listCard: MutableList<Cards>) {
        sortByRarityDesc(listCard)
        val sorted = cards.groupBy { (it.arena) }
        listCard.clear()
        sorted.values.forEach {
            listCard.addAll(it)
        }
    }

    private fun sortByElixir(listCard: MutableList<Cards>) {
        val sorted = listCard.groupBy { (it.elixirCost) }
        val order = TreeMap(sorted)
        listCard.clear()
        order.values.forEach {
            listCard.addAll(it)
        }
    }

    private fun getAllCards() {
        cardPresenter.getAllCards(object : CardListListener {
            override fun onCardListLoad(cardList: MutableList<Cards>) {
                cards = cardList
                sortByRarity(cards)
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
        })
    }
}
