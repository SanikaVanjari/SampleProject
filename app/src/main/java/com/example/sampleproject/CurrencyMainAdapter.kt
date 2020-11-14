package com.example.sampleproject

import android.util.ArrayMap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.currency_main_item_view.view.*

class CurrencyMainAdapter(var map: ArrayMap<String, ArrayMap<String, Double>>?) :
    RecyclerView.Adapter<CurrencyMainAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_main_item_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.dateTitle.text = map!!.keyAt(position)


    }

    override fun getItemCount(): Int = map?.size!!

}
