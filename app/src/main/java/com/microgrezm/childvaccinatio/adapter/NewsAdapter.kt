package com.microgrezm.childvaccination.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.api.Context
import com.microgrezm.childvaccinatio.R
import com.microgrezm.childvaccinatio.showinfo
import com.microgrezm.childvaccination.data.InfoData

class NewsAdapter(var c: android.content.Context?) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    var add: List<InfoData> = emptyList()

    fun setList(list: List<InfoData>) {
        this.add = list

        notifyDataSetChanged()
    }

    class NewsHolder(v: View) : RecyclerView.ViewHolder(v) {
        var title = v.findViewById<TextView>(R.id.titelNewsTV)
        var body = v.findViewById<TextView>(R.id.bodyNewsTV)
        var card = v.findViewById<CardView>(R.id.card_news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        return NewsHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.title.text = add[position].title
        holder.body.text = add[position].body
        holder.card.setOnClickListener {
            var intent = Intent(c, showinfo::class.java)
            intent.putExtra("title", add[position].title)
            intent.putExtra("body", add[position].body)
            ContextCompat.startActivity(c!!, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return add.size
    }
}