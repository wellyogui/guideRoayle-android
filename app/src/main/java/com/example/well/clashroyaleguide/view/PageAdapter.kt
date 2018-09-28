package com.example.well.clashroyaleguide.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.well.clashroyaleguide.card.CardFragment
import com.example.well.clashroyaleguide.player.PlayerDetailFragment

class PageAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private var mNumOfTabs: Int = 0

    private var fragments: MutableList<Fragment> = arrayListOf()

    init {
        fragments.add(PlayerDetailFragment())
        fragments.add(CardFragment())

        mNumOfTabs = fragments.size
    }

    override fun getItem(position: Int): Fragment {
        lateinit  var fragment: Fragment

        when (position){
            0 -> fragment = PlayerDetailFragment()

            1 -> fragment = CardFragment()
        }

        return fragment
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}