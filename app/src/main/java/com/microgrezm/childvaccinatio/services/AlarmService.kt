package com.microgrezm.childvaccination.services

import android.annotation.SuppressLint
import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.microgrezm.childvaccinatio.Alarms
import com.microgrezm.childvaccinatio.MainView
import com.microgrezm.childvaccinatio.R
import com.microgrezm.childvaccinatio.services.ReplayService
import java.util.*
import java.util.Optional.empty

class AlarmService : BroadcastReceiver() {
    companion object{
        var number = 0}

        var idNotofi : Int = 0


    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        var message : String = intent.getStringExtra("x")!!
        showNotification(context,"new appointment ", " $message ", idNotofi.toString())
        var alarmIntent = Intent(context,Alarms::class.java)
        alarmIntent.flags=FLAG_ACTIVITY_NEW_TASK
        alarmIntent.putExtra("message",message)
        context.startActivities(arrayOf(alarmIntent))
    }
    @SuppressLint("RestrictedApi")
    fun showNotification(context: Context, title: String, text: String, nChanalID: String) {
        var mNfcManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        var intent = Intent(context,MainView::class.java)
        var intent1 = Intent(context, ReplayService::class.java)
        intent1.putExtra("x1",text)
        var pIntent = PendingIntent.getActivities(context,0, arrayOf(intent),0 )
        var pIntent1 = PendingIntent.getBroadcast(context,0, intent1,0 )
        var mBuilder = NotificationCompat.Builder(context)

        mBuilder.setSmallIcon(R.drawable.baby)
        mBuilder.setContentTitle(title)
        mBuilder.setContentText(text)
        mBuilder.setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
        mBuilder.addAction(R.drawable.re,"5 minutes later",pIntent1).setAutoCancel(true)
        mBuilder.addAction(R.drawable.cancel,"Cancel",pIntent).setAutoCancel(true)
        mBuilder.addAction(R.drawable.check,"Done",pIntent).setAutoCancel(true)
        mBuilder.setAutoCancel(true)





        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            var nChannel =
                NotificationChannel(nChanalID, "new", NotificationManager.IMPORTANCE_HIGH)
            mBuilder.setChannelId(nChanalID)
            mNfcManager.createNotificationChannel(nChannel)

        }
        mNfcManager.notify(number, mBuilder.build())
        number++
    }
    fun startAlarm(context: Context,message: String, id : Int) {




        val am = context
            .getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
        val cal = Calendar.getInstance()
        cal.set(Calendar.MINUTE, 1)
        cal.set(Calendar.SECOND, 0)
        am.set(
            AlarmManager.RTC_WAKEUP,
            cal.timeInMillis,
            PendingIntent.getBroadcast(
                context.applicationContext, 0,null,0
            )
        )
    }


}




