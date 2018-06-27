package com.example.well.clashroyaleguide.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.well.clashroyaleguide.arena.ArenaFragment
import com.example.well.clashroyaleguide.card.CardFragment
import com.example.well.clashroyaleguide.deck.DeckFragment
import com.example.well.clashroyaleguide.player.PlayerFragment

class PageAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private var mNumOfTabs: Int = 0

    private var fragments: MutableList<Fragment> = arrayListOf()

    init {
        fragments.add(ArenaFragment())
        fragments.add(CardFragment())
        fragments.add(DeckFragment())
        fragments.add(PlayerFragment())

        mNumOfTabs = fragments.size
    }

    override fun getItem(position: Int): Fragment {
        lateinit  var fragment: Fragment

        when (position){
            0 -> fragment = ArenaFragment()

            1 -> fragment = CardFragment()

            2 -> fragment = DeckFragment()

            3 -> fragment = PlayerFragment()
        }

        return fragment
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}