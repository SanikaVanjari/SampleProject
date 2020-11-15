package com.example.sampleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.detail_item.view.*

class DetailAdapter(var arrayMap: android.util.ArrayMap<String, Double>?) : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.detail_item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.currency.text= arrayMap?.keyAt(position)
        holder.itemView.value.text= arrayMap!![arrayMap!!.keyAt(position)].toString()
    }

    override fun getItemCount(): Int = arrayMap?.size!!

}
