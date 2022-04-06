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
import com.microgrezm.childvaccination.adapter.ChildAdapter
import com.microgrezm.childvaccination.data.ChildData
import com.microgrezm.childvaccination.database.ChildDatabase
import com.microgrezm.childvaccination.database.LocalRepositoryIpm
import kotlinx.coroutines.*

class ListFragment : Fragment() {
    private var rv: RecyclerView? = null
    lateinit var localRepositoryIpm: LocalRepositoryIpm
    var progressBar: ProgressBar? = null
    //  var myAdapter: ChildAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_list, container, false)
        progressBar = v.findViewById(R.id.progressBar2)
        rv = v.findViewById(R.id.rv_list)

        var dbR = ChildDatabase.getInstance(requireContext())
        localRepositoryIpm = LocalRepositoryIpm(dbR)

        var myAdapter = ChildAdapter(requireContext())

        GlobalScope.launch(Dispatchers.IO) {
            var returnedChild = async {
                localRepositoryIpm.childGet()
            }
            withContext(Dispatchers.Main) {
                progressBar!!.visibility = View.VISIBLE
                var myArr1: List<ChildData>  = returnedChild.await()
                progressBar!!.visibility = View.GONE
                myAdapter.setList(myArr1)
                myAdapter.notifyDataSetChanged()

            }
        }
        val myLayoutManager1 = GridLayoutManager(context, 1)
        rv!!.adapter = myAdapter
        rv!!.layoutManager = myLayoutManager1
        rv!!.itemAnimator = DefaultItemAnimator()
        myAdapter.notifyDataSetChanged()


        return v
    }

}