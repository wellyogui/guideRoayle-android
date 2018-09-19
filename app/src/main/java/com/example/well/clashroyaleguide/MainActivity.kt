package com.example.well.clashroyaleguide

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.example.well.clashroyaleguide.card.CardFragment
import com.example.well.clashroyaleguide.deck.DeckFragment
import com.example.well.clashroyaleguide.player.PlayerFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by wellingtonyogui on 18/09/2018 for guideRoayle-android.
 */
class MainActivity: AppCompatActivity() {
    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.let {
            toolbar = it
        }

        val bottomNavigation: BottomNavigationView = navigationView
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            //TODO: Implementar busca,
            R.id.navigation_player -> {
                toolbar.title = "Player"
                val playerFragment = PlayerFragment.newInstance()
                openFragment(playerFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cards -> {
                toolbar.title = "Cartas"
                val cardFragment = CardFragment.newInstance()
                openFragment(cardFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_decks -> {
                toolbar.title = "Decks"
                val deckFragment = DeckFragment.newInstance()
                openFragment(deckFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}