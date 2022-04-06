package com.microgrezm.childvaccinatio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.microgrezm.childvaccination.adapter.DatsAdapter
import com.microgrezm.childvaccination.data.ChildData
import com.microgrezm.childvaccination.database.ChildDatabase
import com.microgrezm.childvaccination.database.LocalRepositoryIpm
import kotlinx.coroutines.*

class ShowChildData : AppCompatActivity() {
    var nameShow: TextView? = null
    var birthTV: TextView? = null
    var genderTV: TextView? = null
    var rv: RecyclerView? = null
    var arrMe: List<datsData> = emptyList()
    lateinit var localRepositoryIpm: LocalRepositoryIpm
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_child_data)
        nameShow = findViewById(R.id.name_showTV)
        birthTV = findViewById(R.id.parth_showTV)
        genderTV = findViewById(R.id.gindar_showTV)
        rv = findViewById(R.id.rv_show)
        progressBar = findViewById(R.id.progressBar4)
        var dbR = ChildDatabase.getInstance(this)
        localRepositoryIpm = LocalRepositoryIpm(dbR)
        var myAdapterView = DatsAdapter(this)
        var id = intent.getIntExtra("chID",0)
        var name: String
        var birth: String
        var gender: String
        GlobalScope.launch(Dispatchers.IO) {
            var returnedChild = async {
                localRepositoryIpm.getChildByID(id)
            }
            withContext(Dispatchers.Main) {
                progressBar!!.visibility = View.VISIBLE
                var myArr1: List<ChildData> = returnedChild.await()
                progressBar!!.visibility = View.GONE
                name = myArr1[0].childName
                birth = myArr1[0].birthDay
                gender = myArr1[0].childGender
                arrMe = convertToArr(myArr1)
                myAdapterView.setList(arrMe)
                myAdapterView.notifyDataSetChanged()
                nameShow!!.text = name
                birthTV!!.text = birth
                genderTV!!.text = gender
            }
        }


        var myLayoutManager1 = GridLayoutManager(this, 1)
        rv!!.adapter = myAdapterView
        rv!!.itemAnimator = DefaultItemAnimator()
        rv!!.layoutManager = myLayoutManager1



    }

    fun convertToArr(arr: List<ChildData>): ArrayList<datsData> {
        var array = ArrayList<datsData>()
        array.add(datsData(arr[0].Desc1))
        array.add(datsData(arr[0].Desc2))
        array.add(datsData(arr[0].Desc5))
        array.add(datsData(arr[0].Desc3))
        array.add(datsData(arr[0].Desc6))
        array.add(datsData(arr[0].Desc8))
        array.add(datsData(arr[0].Desc13))
        array.add(datsData(arr[0].Desc17))
        array.add(datsData(arr[0].Desc21))
        array.add(datsData(arr[0].Desc7))
        array.add(datsData(arr[0].Desc24))
        array.add(datsData(arr[0].Desc26))
        array.add(datsData(arr[0].Desc9))
        array.add(datsData(arr[0].Desc14))
        array.add(datsData(arr[0].Desc18))
        array.add(datsData(arr[0].Desc22))
        array.add(datsData(arr[0].Desc4))
        array.add(datsData(arr[0].Desc10))
        array.add(datsData(arr[0].Desc15))
        array.add(datsData(arr[0].Desc19))
        array.add(datsData(arr[0].Desc23))
        array.add(datsData(arr[0].Desc27))
        array.add(datsData(arr[0].Desc11))
        array.add(datsData(arr[0].Desc16))
        array.add(datsData(arr[0].Desc20))
        array.add(datsData(arr[0].Desc28))
        array.add(datsData(arr[0].Desc30))
        array.add(datsData(arr[0].Desc29))
        array.add(datsData(arr[0].Desc25))
        array.add(datsData(arr[0].Desc31))
        array.add(datsData(arr[0].Desc12))

        return array
    }

    override fun onBackPressed() {
        this.finish()
        super.onBackPressed()
    }
}

data class datsData(var date: String)