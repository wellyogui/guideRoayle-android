package com.example.well.clashroyaleguide.arena

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.well.clashroyaleguide.R
import com.example.well.clashroyaleguide.service.model.Arena
import kotlinx.android.synthetic.main.arena_list_row.view.*

internal const val imageURl = "http://www.clashapi.xyz/images/arenas/%s.png"

class ArenaAdapter(var arenaList: MutableList<Arena>?) : RecyclerView.Adapter<ArenaAdapter.ArenaAdapterViewHolder>() {

    lateinit var context: Context
    lateinit var arena: Arena

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArenaAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.arena_list_row, parent, false)

        context = parent.context

        return ArenaAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arenaList!!.size
    }

    override fun onBindViewHolder(holder: ArenaAdapterViewHolder, position: Int) {
        holder.bind(arenaList?.get(position)!!)
    }

    fun addAllArenas(arenas: MutableList<Arena>) {
        if (arenaList != null) {
            arenaList = arenas
        } else {
            arenaList
        }
    }

    class ArenaAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(arena: Arena) = with(itemView){
            with(arena){
                arenaNameView.text = arena.name
                arenaNumberView.text = arena.number.toString()
                arenaTrophyView.text = arena.minTrophies.toString().plus("+")
                Glide.with(context)
                        .load(String.format(imageURl, arena.idName))
                        .into(arenaImageView)

            }

        }
    }
}