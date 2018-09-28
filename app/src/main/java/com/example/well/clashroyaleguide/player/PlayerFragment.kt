package com.example.well.clashroyaleguide.player

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.view.PageAdapter
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment : Fragment() {

    companion object {
        fun newInstance(): PlayerFragment = PlayerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        setTabs()

        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    private fun setTabs() {
        val fragmentManager = this.activity?.let {
            it.supportFragmentManager
        }

        tabView.removeAllTabs()

        tabView.addTab(tabView.newTab().setText("Perfil"))
        tabView.addTab(tabView.newTab().setText("Deck"))

        val pageAdapter = PageAdapter(fragmentManager)
        viewPagerView.adapter = pageAdapter
        viewPagerView.offscreenPageLimit = tabView.tabCount
        viewPagerView.currentItem = 0
        viewPagerView.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabView))
        tabView.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                // UNUSED
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // UNUSED
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPagerView.currentItem = tab.position
                }
            }

        })
    }

}