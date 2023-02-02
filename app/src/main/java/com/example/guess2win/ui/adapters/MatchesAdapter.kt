package com.example.guess2win.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guess2win.data.model.Match
import com.example.guess2win.R

class MatchesAdapter: RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {
    private lateinit var onItemListner: SentDetails
   var movieslist: List<Match> = emptyList()

    fun setList(data: List<Match>) {
        if(data.isEmpty()){
            Log.d("size","Sizezero")
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
            .inflate(R.layout.list_of_matches, parent, false)
        return ViewHolder(view, onItemListner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: Match = movieslist[position]
        holder.setId(data)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    inner class ViewHolder(itemView: View, itemlistner: SentDetails) :
        RecyclerView.ViewHolder(itemView) {
        var clubOneNume: TextView = itemView.findViewById<TextView>(R.id.clubname_one)
        var clubTwoNume: TextView = itemView.findViewById<TextView>(R.id.clubname_two)

        init {
            itemView.setOnClickListener {
                onItemListner.onItemClick(movieslist[adapterPosition].toString())
            }

        }


        fun setId(data: Match) {
           clubOneNume.text=data.clubOneName
           clubTwoNume.text=data.clubTwoName
        }


    }

}