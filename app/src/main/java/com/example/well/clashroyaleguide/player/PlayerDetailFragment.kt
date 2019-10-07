package com.example.well.clashroyaleguide.player

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.well.clashroyaleguide.R

/**
 * Created by wellingtonyogui on 27/09/2018 for guideRoayle-android.
 */
class PlayerDetailFragment : Fragment() {

    companion object {
        fun newInstace(): PlayerDetailFragment = PlayerDetailFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_player_detail, container, false)
        return view
    }
}