package com.example.sampleproject

import android.content.Context
import android.util.ArrayMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.currency_main_item_view.view.*
import java.text.SimpleDateFormat

class CurrencyMainAdapter(var map: ArrayMap<String, ArrayMap<String, Double>>?) :
    RecyclerView.Adapter<CurrencyMainAdapter.ViewHolder>() {


    class ViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_main_item_view, parent, false)
        return ViewHolder(v, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //example: dateLabel= Date: 15/11/2020
        val dateLabel = holder.itemView.context.getString(R.string.date_label) + formatDate(
            map!!.keyAt(
                position
            ).toString()
        )
        holder.itemView.dateTitle.text = dateLabel

        holder.itemView.detailRV.apply {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = DetailAdapter(map!![map!!.keyAt(position)])
        }

    }

    private fun formatDate(dateFromApi: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("dd/MMM/yyyy")
        return formatter.format(parser.parse(dateFromApi))
    }

    override fun getItemCount(): Int = map?.size!!

}
