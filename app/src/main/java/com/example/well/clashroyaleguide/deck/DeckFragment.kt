package com.example.well.clashroyaleguide.deck


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.well.clashroyaleguide.R


/**
 * A simple [Fragment] subclass.
 */
class DeckFragment: Fragment() {


    companion object {
        fun newInstance(): DeckFragment = DeckFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cards, container, false)
    }

}// Required empty public constructor
