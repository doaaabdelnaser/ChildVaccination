package com.microgrezm.childvaccination.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.microgrezm.childvaccinatio.R
import com.microgrezm.childvaccinatio.ShowChildData
import com.microgrezm.childvaccination.data.ChildData
import com.microgrezm.childvaccination.data.childrnData
import com.microgrezm.childvaccination.database.ChildDatabase
import com.microgrezm.childvaccination.database.LocalRepositoryIpm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class ChildAdapter(var c: Context) :
    RecyclerView.Adapter<ChildAdapter.ChildHolder>() {
    var add: List<ChildData> = emptyList()
    fun setList(list: List<ChildData>) {
        this.add = list
        notifyDataSetChanged()
    }

    inner class ChildHolder(view: View) : RecyclerView.ViewHolder(view) {
        var card = view.findViewById<CardView>(R.id.childCardView)
        var childNameTV = view.findViewById<TextView>(R.id.nameTV)
        var birthTV = view.findViewById<TextView>(R.id.birthTV)
        var genderTV = view.findViewById<TextView>(R.id.genderTV)
        //var delete = view.findViewById<ImageButton>(R.id.delet)
        // var eidt = view.findViewById<ImageButton>(R.id.edat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_view, parent, false)
        return ChildHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {

        holder.childNameTV.text = add[position].childName
        holder.birthTV.text = add[position].birthDay
        holder.genderTV.text = add[position].childGender
        holder.card.setOnClickListener {

            val intent = Intent(c, ShowChildData::class.java)
            intent.putExtra("chID", add[position].id)
            intent.putExtra("childId",add[position].id)
           // Toast.makeText(c, " ${add[position].id}", Toast.LENGTH_SHORT).show()
            startActivity(c, intent, null)


        }

    }

    override fun getItemCount(): Int {
        return add.size
    }
}