package com.microgrezm.childvaccination.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.microgrezm.childvaccinatio.R
import com.microgrezm.childvaccinatio.showinfo

import com.microgrezm.childvaccination.data.InfoData


class InfoAdapter(var c: Context?): RecyclerView.Adapter<InfoAdapter.InfoHolder>() {

    var add: List<InfoData> = emptyList()
    fun setList(list : List<InfoData>) {
        this.add = list
        notifyDataSetChanged()
            }
    inner class InfoHolder(view: View) : RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.titelTV)
        var body = view.findViewById<TextView>(R.id.badyTV)
        var card = view.findViewById<CardView>(R.id.cardInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.info_item, parent, false)
        return InfoHolder(itemView)
    }

    override fun onBindViewHolder(holder: InfoHolder, position: Int) {
        holder.body.text = add[position].body
        holder.title.text = add[position].title
        holder.card.setOnClickListener {
            var intent = Intent(c, showinfo::class.java)
            intent.putExtra("title",add[position].title)
            intent.putExtra("body",add[position].body)
            ContextCompat.startActivity(c!!, intent, null)
        }

    }

    override fun getItemCount(): Int {
       return add.size
    }

}

