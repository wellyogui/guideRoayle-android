package com.example.well.clashroyaleguide.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.model.Arena
import com.example.well.clashroyaleguide.presenter.ArenaPresenter
import com.example.well.clashroyaleguide.sync.contracts.ArenaListListener
import com.example.well.clashroyaleguide.view.adapter.ArenaAdapter

class ArenaFragment : Fragment() {

    @BindView(R.id.rvArenas)
    lateinit var arenaRecyler: RecyclerView

    lateinit var arenaAdapter: ArenaAdapter
    lateinit var arenas: MutableList<Arena>
    private val arenaPresenter = ArenaPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_arena, container, false)
        ButterKnife.bind(this, view)

        val linearLayout = LinearLayoutManager(context)
        arenaRecyler.layoutManager = linearLayout

        getArenaList()

        return view
    }

    private fun getArenaList() {
        arenaPresenter.loadArenaList(object: ArenaListListener {
            override fun onArenaListLoad(arenaList: MutableList<Arena>) {
                arenas = arenaList

                arenaAdapter = ArenaAdapter(arenas)
                arenaAdapter.addAllArenas(arenas)
                arenaRecyler.adapter = arenaAdapter
            }

            override fun onRequestStarted() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onRequestFinished() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(error: Throwable) {
                Log.e("getArenaList", error.message)
            }

        })
    }
}
