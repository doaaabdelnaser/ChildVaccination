package com.microgrezm.childvaccinatio.services

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.microgrezm.childvaccinatio.MainView
import com.microgrezm.childvaccinatio.R
import com.microgrezm.childvaccination.services.AlarmService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ReplayService : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "postponed", Toast.LENGTH_SHORT).show()
        GlobalScope.launch(Dispatchers.Main) {
        var m = intent!!.getStringExtra("x1")
        showNotification(context!!, "Remind of an appointment", m!!, "1")
    }}


    @SuppressLint("RestrictedApi")
   suspend fun showNotification(context: Context, title: String, text: String, nChanalID: String) {
        var mNfcManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        var mBuilder = NotificationCompat.Builder(context)

        mBuilder.setSmallIcon(R.drawable.baby)
        mBuilder.setContentTitle(title)
        mBuilder.setContentText(text)
        mBuilder.setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
        mBuilder.addAction(R.drawable.re, "5 minutes later", null).setAutoCancel(true)
        mBuilder.addAction(R.drawable.cancel, "Cancel", null).setAutoCancel(true)
        mBuilder.addAction(R.drawable.check, "Done", null).setAutoCancel(true)
        mBuilder.setAutoCancel(true)





        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            var nChannel =
                NotificationChannel(nChanalID, "new", NotificationManager.IMPORTANCE_HIGH)
            mBuilder.setChannelId(nChanalID)
            mNfcManager.createNotificationChannel(nChannel)

        }
        delay(60000L)
        mNfcManager.notify(AlarmService.number, mBuilder.build())
        AlarmService.number++
    }


}