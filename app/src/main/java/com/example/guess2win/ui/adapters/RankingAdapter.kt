package com.example.guess2win.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guess2win.data.model.PlayersRanking
import com.example.guess2win.R

class RankingAdapter : RecyclerView.Adapter<RankingAdapter.ViewHolder>() {
    private lateinit var onItemListner: SentDetails
    var movieslist: List<PlayersRanking> = emptyList()

    fun setList(data: List<PlayersRanking>) {
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
            .inflate(R.layout.ranking_item, parent, false)
        return ViewHolder(view, onItemListner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: PlayersRanking = movieslist[position]
        holder.setId(data)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    inner class ViewHolder(itemView: View, itemlistner: SentDetails) :
        RecyclerView.ViewHolder(itemView) {
        var nameOfPlayer: TextView = itemView.findViewById<TextView>(R.id.textView27)
        var points: TextView = itemView.findViewById<TextView>(R.id.textView29)

        init {
            itemView.setOnClickListener {
                onItemListner.onItemClick(movieslist[adapterPosition].toString())
            }

        }


        fun setId(data: PlayersRanking) {
            nameOfPlayer.text = data.name
            points.text = data.points.toString()
        }


    }

}