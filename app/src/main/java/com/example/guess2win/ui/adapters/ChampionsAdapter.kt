package com.example.guess2win.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guess2win.data.model.Champions
import com.example.guess2win.R

class ChampionsAdapter : RecyclerView.Adapter<ChampionsAdapter.ViewHolder>() {
    private lateinit var onItemListner: SentDetails
    var movieslist: List<Champions> = emptyList()

    fun setList(data: List<Champions>) {
        if (data.isEmpty()) {
            Log.d("size", "Sizezero")
        }
        this.movieslist = data
        notifyDataSetChanged()
    }

    interface SentDetails {
        fun onItemClick(postion: String)
    }

    fun setOnItemClick(item: SentDetails) {
        this.onItemListner = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.champions_item, parent, false)
        return ViewHolder(view, onItemListner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: Champions = movieslist[position]
        holder.setId(data)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    inner class ViewHolder(itemView: View, itemlistner: SentDetails) :
        RecyclerView.ViewHolder(itemView) {
        var imageofChampion: ImageView = itemView.findViewById<ImageView>(R.id.img_champion)
        var nameOfchampion: TextView = itemView.findViewById<TextView>(R.id.champion_list_tv1)


        init {
            itemView.setOnClickListener {
                onItemListner.onItemClick(movieslist[adapterPosition].toString())
            }

        }


        fun setId(data: Champions) {
            nameOfchampion.text = data.nameOfChampion

        }


    }

}