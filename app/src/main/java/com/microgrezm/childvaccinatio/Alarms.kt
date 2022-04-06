package com.microgrezm.childvaccinatio

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.microgrezm.childvaccination.services.AlarmService
import java.util.*

class Alarms : AppCompatActivity() {
    var done   : ImageButton? = null
    var cancel : ImageButton? = null
    var after : ImageButton? = null
    var text : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarms)
        done = findViewById(R.id.imageButton3)
        cancel = findViewById(R.id.imageButton2)
        after = findViewById(R.id.imageButton)
        text =findViewById(R.id.newDate)
        var message = intent.getStringExtra("message")
        text!!.text = message
        done!!.setOnClickListener {
            this.finish()
        }
        cancel!!.setOnClickListener {
            this.finish()
        }
        after!!.setOnClickListener {
            startAlarm(message!!,1)
            finish()
        }
    }
    fun startAlarm(message: String, id : Int) {
        var alS = AlarmService()

        val intent = Intent(this, alS::class.java)
        intent.putExtra("x",message)
        val am = getSystemService(ALARM_SERVICE) as AlarmManager
        val cal = Calendar.getInstance()
        cal.set(Calendar.MINUTE, 2)
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