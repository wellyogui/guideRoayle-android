package com.example.well.clashroyaleguide.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.model.Arena
import com.example.well.clashroyaleguide.view.adapter.ArenaAdapter.ArenaAdapterViewHolder

class ArenaAdapter(var arenaList: MutableList<Arena>?) : RecyclerView.Adapter<ArenaAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArenaAdapterViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.arena_list_row, parent, false)

        return ArenaAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arenaList!!.size
    }

    override fun onBindViewHolder(holder: ArenaAdapterViewHolder, position: Int) {
        val arena: Arena? = arenaList?.get(position)

        holder.tvArenaName.text = arena?.name
    }

    fun addAllArenas(arenas: MutableList<Arena>) {
        if (arenaList != null) {
            arenaList = arenas
        } else {
            arenaList
        }
    }

    inner class ArenaAdapterViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView?.findViewById(R.id.tv_arena_name)){

        val tvArenaName: TextView = itemView!!.findViewById(R.id.tv_arena_name)

    }
}