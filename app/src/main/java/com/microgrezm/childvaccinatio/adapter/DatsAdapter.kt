package com.microgrezm.childvaccination.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.microgrezm.childvaccinatio.R
import com.microgrezm.childvaccinatio.datsData

import com.microgrezm.childvaccination.data.ChildData


class DatsAdapter (var c: Context): RecyclerView.Adapter<DatsAdapter.DatSHolder>() {

    var add: List<datsData> = emptyList()
    fun setList(list : List<datsData>){
        this.add = list
        notifyDataSetChanged()
    }
    inner class DatSHolder(view: View) : RecyclerView.ViewHolder(view){
        var dats = view.findViewById<TextView>(R.id.datsTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatSHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.dats_item, parent, false)
        return DatSHolder(itemView)

    }

    override fun onBindViewHolder(holder: DatSHolder, position: Int) {
        holder.dats.text = add[position].date
    }

    override fun getItemCount(): Int {
        return add.size
    }
}