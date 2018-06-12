package com.example.well.clashroyaleguide.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.model.Arena
import com.example.well.clashroyaleguide.view.adapter.ArenaAdapter.ArenaAdapterViewHolder
import kotlinx.android.synthetic.main.arena_list_row.view.*

class ArenaAdapter(var arenaList: MutableList<Arena>?) : RecyclerView.Adapter<ArenaAdapterViewHolder>() {

    lateinit var context: Context

    val imageURl = "http://www.clashapi.xyz/images/arenas/"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArenaAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.arena_list_row, parent, false)

        context = parent.context

        return ArenaAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arenaList!!.size
    }

    override fun onBindViewHolder(holder: ArenaAdapterViewHolder, position: Int) {
        val arena: Arena? = arenaList?.get(position)

        holder.tvArenaName.text = arena?.name

        Glide.with(context)
                .load(imageURl.plus(arena?.idName).plus(".png"))
                .into(holder.arenaImageView)

    }

    fun addAllArenas(arenas: MutableList<Arena>) {
        if (arenaList != null) {
            arenaList = arenas
        } else {
            arenaList
        }
    }

    class ArenaAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvArenaName = itemView.tv_arena_name
        val arenaImageView = itemView.arenaImageView

    }
}