package com.microgrezm.childvaccinatio

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.ImageButton
import android.widget.Toast
import com.microgrezm.childvaccination.services.AlarmService
import java.util.*

class MainView : AppCompatActivity() {
    var add: ImageButton? = null
    var childList: ImageButton? = null
    var info: ImageButton? = null
    var medicalInfo: ImageButton? = null
    var map: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)
        add = findViewById(R.id.add)
        childList = findViewById(R.id.listIChild)
        info = findViewById(R.id.info)
        medicalInfo = findViewById(R.id.infoMedcal)
        map = findViewById(R.id.map)
        var structiure = intent.getStringExtra("activity")
        if (structiure == "first log") {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, AddFragment())
                    .commitNow()
            }
        } else if (structiure == "notFirst") {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, ListFragment())
                    .commitNow()
            }
        }

        add!!.setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, AddFragment())
                    .commitNow()
            }
        }
        childList!!.setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, ListFragment())
                    .commitNow()
            }
        }
        info!!.setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, InfoFragment())
                    .commitNow()
            }

            // GlobalScope.launch(Dispatchers.Default) {
            //val intent = Intent(this, AlarmService::class.java)
            // startAlarm(12)
            //startService(intent)

            startAlarm(7,"new data",11,1)
            startAlarm(8,"new x" ,11,2)

            Toast.makeText(this, "i = ", Toast.LENGTH_SHORT).show()
        }
        medicalInfo!!.setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, MedicalInfoFragment())
                    .commitNow()
            }
        }
        map!!.setOnClickListener {
            val uri = String.format(Locale.ENGLISH, "geo:0,0?q=34.99,-106.61(Treasure)")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        }


    }

    fun startAlarm(m: Int ,message: String,dd:Int, id : Int) {
        var y = 2021
        var mo = 7
        var alS = AlarmService()

        val intent = Intent(this, alS::class.java)
        intent.putExtra("x",message)
        val am = getSystemService(ALARM_SERVICE) as AlarmManager
        val cal = Calendar.getInstance()
        //cal.set(y-0,mo-1,dd-0,3,m)
        cal.set(Calendar.YEAR, y)
        cal.set(Calendar.MONTH, mo-1)
        Toast.makeText(this, " & d= $dd", Toast.LENGTH_SHORT).show()
        cal.set(Calendar.DAY_OF_MONTH,dd-0)
        cal.set(Calendar.HOUR_OF_DAY, 4)
        cal.set(Calendar.MINUTE, m)
        cal.set(Calendar.SECOND, 0)
        am.set(
            AlarmManager.RTC_WAKEUP,
            cal.timeInMillis,
            PendingIntent.getBroadcast(
                applicationContext, id, intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        )
    }
}