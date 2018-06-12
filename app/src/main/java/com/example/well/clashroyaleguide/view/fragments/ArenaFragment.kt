package com.example.well.clashroyaleguide.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.model.Arena
import com.example.well.clashroyaleguide.presenter.ArenaPresenter
import com.example.well.clashroyaleguide.sync.contracts.ArenaListListener
import com.example.well.clashroyaleguide.view.adapter.ArenaAdapter
import kotlinx.android.synthetic.main.fragment_arena.*
import kotlinx.android.synthetic.main.fragment_arena.view.*


class ArenaFragment : Fragment() {

    lateinit var arenaAdapter: ArenaAdapter
    lateinit var arenas: MutableList<Arena>
    private val arenaPresenter = ArenaPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_arena, container, false)

        val linearLayout = LinearLayoutManager(context)
        view.arena_list_view.layoutManager = linearLayout

        getArenaList()

        return view
    }

    private fun getArenaList() {
        arenaPresenter.loadArenaList(object: ArenaListListener {
            override fun onArenaListLoad(arenaList: MutableList<Arena>) {
                arenas = arenaList

                arenaAdapter = ArenaAdapter(arenas)
                arenaAdapter.addAllArenas(arenas)
                arena_list_view.adapter = arenaAdapter
            }

            override fun onRequestStarted() {
                Log.d("start", "Start")
            }

            override fun onRequestFinished() {
                Log.d("finished", "Finished")
            }

            override fun onError(error: Throwable) {
                Log.e("getArenaList", error.message)
            }

        })
    }
}
