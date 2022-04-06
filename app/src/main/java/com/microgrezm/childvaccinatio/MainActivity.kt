package com.microgrezm.childvaccinatio

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.microgrezm.childvaccination.services.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null


    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("getVal", Context.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        var counter = sharedPreferences!!.getInt("number",0)

        val intentServes = Intent(this, Player::class.java)
        val intentActivity = Intent(this, MainView::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            startServesFun(intentServes)
            firstLogin(counter , intentActivity)
            counter = 1
            editor!!.putInt("number",counter)
            editor!!.apply()

        }

    }

    private suspend fun startServesFun(intentService: Intent) {

        startService(intentService)
        delay(5000L)
        stopService(intentService)

    }

    private fun firstLogin (number : Int , intentActivity : Intent){
        if (number == 0){
            val intent = Intent(this,FirstLogin::class.java)
            startActivity(intent)
            finish()
        }else {
            intentActivity.putExtra("activity", "notFirst")
            startActivity(intentActivity)
            finish()
        }
    }

}