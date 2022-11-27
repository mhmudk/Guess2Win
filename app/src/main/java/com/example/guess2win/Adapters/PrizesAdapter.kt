package com.example.guess2win.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guess2win.Model.Match
import com.example.guess2win.Model.Prize
import com.example.guess2win.R

class PrizesAdapter: RecyclerView.Adapter<PrizesAdapter.ViewHolder>() {
    private lateinit var onItemListner: SentDetails
   var movieslist: List<Prize> = emptyList()

    fun setList(data: List<Prize>) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrizesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_prize, parent, false)
        return ViewHolder(view, onItemListner)
    }

    override fun onBindViewHolder(holder: PrizesAdapter.ViewHolder, position: Int) {
        val data: Prize = movieslist[position]
        holder.setId(data)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    inner class ViewHolder(itemView: View, itemlistner: SentDetails) :
        RecyclerView.ViewHolder(itemView) {
        var nameOfPrize: TextView = itemView.findViewById<TextView>(R.id.name_of_prize)
        var start_number: TextView = itemView.findViewById<TextView>(R.id.start_of_number)
        var end_number: TextView = itemView.findViewById<TextView>(R.id.end_of_number)
        var imageOfPrize: ImageView = itemView.findViewById<ImageView>(R.id.img_for_prize)

        init {
            itemView.setOnClickListener {
                onItemListner.onItemClick(movieslist[adapterPosition].toString())
            }

        }


        fun setId(data: Prize) {
            nameOfPrize.text=data.nameOfPrize
            start_number.text=data.startOfPrize
            end_number.text=data.endOfPrize
            //Picasso to load Image
        }


    }

}