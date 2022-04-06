package com.microgrezm.childvaccinatio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.microgrezm.childvaccination.adapter.LinksAdapter
import com.microgrezm.childvaccination.adapter.NewsAdapter
import com.microgrezm.childvaccination.data.InfoData

class MedicalInfoFragment : Fragment() {

    var rv: RecyclerView? = null
    var rvLinks: RecyclerView? = null

    // var rvLinks: RecyclerView? = null
    var progressBar: ProgressBar? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_medical_info, container, false)
        var db = FirebaseFirestore.getInstance()
        rv = v.findViewById(R.id.rv_news)
        rvLinks = v.findViewById(R.id.recyclerViewLinks)
        progressBar = v.findViewById(R.id.progressBar3)
        var myAdapter = NewsAdapter(context)
        var myAdapterLinks = LinksAdapter(requireContext())
        var myArr = ArrayList<InfoData>()
        var myArrLinks = ArrayList<InfoData>()
        var myLayoutManager = GridLayoutManager(context, 1)
        var myLayoutManager1 = GridLayoutManager(context, 1)
        progressBar!!.visibility = View.VISIBLE


        db.collection("news").get().addOnSuccessListener {
            for (document: QueryDocumentSnapshot in it) {
                db.collection("news").get()
                    .addOnSuccessListener { result ->
                        myArr.add(
                            InfoData(
                                document.getString("title").toString(),
                                document.getString("body").toString()
                            )
                        )
                        myAdapter.setList(myArr)
                        myAdapter.notifyDataSetChanged()
                    }
            }

            progressBar!!.visibility = View.GONE
        }
        db.collection("linkNews").get().addOnSuccessListener {
            for (document: QueryDocumentSnapshot in it) {
                db.collection("linkNews").get()
                    .addOnSuccessListener { result ->
                        myArrLinks.add(
                            InfoData(
                                document.getString("title").toString(),
                                document.getString("links").toString()
                            )
                        )
                        myAdapterLinks.setList(myArrLinks)
                        myAdapterLinks.notifyDataSetChanged()
                    }
            }



            progressBar!!.visibility = View.GONE
        }


        // rv news
        rv!!.adapter = myAdapter
        rv!!.itemAnimator = DefaultItemAnimator()
        rv!!.layoutManager = myLayoutManager
        // rv Links
        rvLinks!!.adapter = myAdapterLinks
        rvLinks!!.itemAnimator = DefaultItemAnimator()
        rvLinks!!.layoutManager = myLayoutManager1
        return v
    }
}
