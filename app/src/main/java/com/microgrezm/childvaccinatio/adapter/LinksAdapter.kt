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
import com.microgrezm.childvaccinatio.LinksView
import com.microgrezm.childvaccinatio.R
import com.microgrezm.childvaccination.data.InfoData

class

LinksAdapter(var c : Context): RecyclerView.Adapter<LinksAdapter.LinksHolder>() {
   var add = ArrayList<InfoData>()
    fun setList(list : ArrayList<InfoData>) {
        this.add = list
        notifyDataSetChanged()
    }
    inner class LinksHolder(v:View):RecyclerView.ViewHolder(v) {
        var title = v.findViewById<TextView>(R.id.titleLinks)
        var card = v.findViewById<CardView>(R.id.cardLinks)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinksHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.links_viwe_item, parent, false)
        return LinksHolder(itemView)
    }

    override fun onBindViewHolder(holder: LinksHolder, position: Int) {
        holder.title.text = add[position].title
        holder.card.setOnClickListener {
            var intent = Intent(c, LinksView::class.java)
            intent.putExtra("lTitle",add[position].title)
            intent.putExtra("link",add[position].body)
           ContextCompat.startActivity(c, intent, null)

        }
    }

    override fun getItemCount(): Int {
        return add.size
    }
}