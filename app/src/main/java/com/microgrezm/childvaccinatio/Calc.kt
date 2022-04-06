package com.microgrezm.childvaccinatio

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.microgrezm.childvaccination.services.AlarmService
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import android.content.Context.ALARM_SERVICE as ALARM_SERVICE1


class Calc {

    var myArr = ArrayList<vaccineData>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun calcALL(context: Context?, date: String, id: Int): ArrayList<vaccineData> {
        calcBCG(context, date, id)
        calcHepB(context, date, id)
        calcPoliovirus(context, date, id)
        calDTB(context, date, id)
        calcHib(context, date, id)
        calcPCV(context, date, id)
        calcRV(context, date, id)
        calcTyphoid(context, date, id)
        calcMMr(context, date, id)
        calcVaricella(context, date, id)
        calcHPV(context, date, id)
        return myArr
    }

    //1
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcBCG(context: Context?, date: String, id: Int) {
        var firstDesc = date
        var vaccineName = "BCG"
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $firstDesc"
            )
        )
        wordCut(context, firstDesc, id.plus(1),vaccineName)
    }

    //2
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcHepB(context: Context?, date: String, id: Int) {
        var vaccineName = "Desc "
        var firstDesc = date
        wordCut(context, firstDesc, id.plus(2),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $firstDesc",
            )
        )
        // 4 weeks
        var secondDesc = getCalculatedDateK(date, 28)
        wordCut(context, secondDesc, id.plus(3),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $secondDesc",
            )
        )
        // 8 weeks
        var thirdDesc = getCalculatedDateK(secondDesc, 56)
        wordCut(context, thirdDesc, id.plus(4),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $thirdDesc",
            )
        )
    }

    //3.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcPoliovirus(context: Context?, date: String, id: Int) {
        var vaccineName = "Poliovirus "
        var firstDesc = date
        wordCut(context, firstDesc, id.plus(5),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $firstDesc",
            )
        )
        // 4 weeks
        var secondDesc = getCalculatedDateK(date, 28)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $secondDesc",
            )
        )
        wordCut(context, secondDesc, id.plus(6),vaccineName)
        // 4 weeks
        var thirdDesc = getCalculatedDateK(secondDesc, 28)
        wordCut(context, thirdDesc, id.plus(7),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $thirdDesc",
            )
        )

    }

    //4.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calDTB(context: Context?, date: String, id: Int) {
        var vaccineName = "DTB "
        var firstDesc = getCalculatedDateK(date,42)
        wordCut(context, firstDesc, id.plus(8),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $firstDesc",
            )
        )
        // 4 weeks
        var secondDesc = getCalculatedDateK(date, 28)
        wordCut(context, secondDesc, id.plus(9),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                "Dosage time : $secondDesc",
            )
        )
        // 8 weeks
        var thirdDesc = getCalculatedDateK(secondDesc, 56)
        wordCut(context, thirdDesc, id.plus(10),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $thirdDesc",
            )
        )
        //6 month
        var fourthDose = getCalculatedDateK(thirdDesc, 180)
        wordCut(context, fourthDose, id.plus(11),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $fourthDose",
            )
        )
        //2 years
        var fifthDose = getCalculatedDateK(fourthDose, 730)
        wordCut(context, fifthDose, id.plus(12),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $fifthDose",
            )
        )
    }

    //5.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcHib(context: Context?, date: String, id: Int) {
        var vaccineName = "Hib"
        //6 weeks
        var firstDesc = getCalculatedDateK(date, 42)
        wordCut(context, firstDesc, id.plus(13),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $firstDesc",
            )
        )
        // 4 weeks
        var secondDesc = getCalculatedDateK(firstDesc, 28)
        wordCut(context, secondDesc, id.plus(14),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $secondDesc",
            )
        )
        // 4 weeks
        var thirdDesc = getCalculatedDateK(secondDesc, 28)
        wordCut(context, thirdDesc, id.plus(15),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $thirdDesc",
            )
        )
        //6 month
        var fourthDose = getCalculatedDateK(thirdDesc, 180)
        wordCut(context, firstDesc, id.plus(16),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $fourthDose",
            )
        )

    }

    //6.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcPCV(context: Context?, date: String, id: Int) {
        var vaccineName = "PCV"
        //6 weeks
        var firstDesc = getCalculatedDateK(date, 42)
        wordCut(context, firstDesc, id.plus(17),vaccineName)
        // 4 weeks
        var secondDesc = getCalculatedDateK(firstDesc, 28)
        wordCut(context, secondDesc, id.plus(18),vaccineName)
        // 4 weeks
        var thirdDesc = getCalculatedDateK(secondDesc, 28)
        wordCut(context, thirdDesc, id.plus(19),vaccineName)
        //6 month
        var fourthDose = getCalculatedDateK(thirdDesc, 180)
        wordCut(context, fourthDose, id.plus(20),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $firstDesc"
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $secondDesc",
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $thirdDesc",
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $fourthDose",
            )
        )

    }

    //7.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcRV(context: Context?, date: String, id: Int) {
        var vaccineName = "RV"
        //6 weeks
        var firstDesc = getCalculatedDateK(date, 42)
        wordCut(context, firstDesc, id.plus(21),vaccineName)
        // 4 weeks
        var secondDesc = getCalculatedDateK(firstDesc, 28)
        wordCut(context, secondDesc, id.plus(22),vaccineName)
        // 4 weeks
        var thirdDesc = getCalculatedDateK(secondDesc, 28)
        wordCut(context, thirdDesc, id.plus(23),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $firstDesc"
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $secondDesc",
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $thirdDesc",
            )
        )
    }

    //8.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcTyphoid(context: Context?, date: String, id: Int) {
        var vaccineName = "Typhoid"
        //9 weeks
        var firstDesc = getCalculatedDateK(date, 63)
        wordCut(context, firstDesc, id.plus(24),vaccineName)
        // 4 weeks
        var secondDesc = getCalculatedDateK(firstDesc, 450)
        wordCut(context, secondDesc, id.plus(25),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $firstDesc"
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $secondDesc",
            )
        )
    }

    //9.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcMMr(context: Context?, date: String, id: Int) {
        var vaccineName = "MMr"

        //9 weeks
        var firstDesc = getCalculatedDateK(date, 63)
        wordCut(context, firstDesc, id.plus(26),vaccineName)
        // 6 month
        var secondDesc = getCalculatedDateK(firstDesc, 180)
        wordCut(context, secondDesc, id.plus(27),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $firstDesc"
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $secondDesc",
            )
        )
    }

    //10.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcVaricella(context: Context?, date: String, id: Int) {
        var vaccineName = "Varicella"
        //1 year
        var firstDesc = getCalculatedDateK(date, 365)
        wordCut(context, firstDesc, id.plus(28),vaccineName)
        //3 year
        var secondDesc = getCalculatedDateK(firstDesc, 1095)
        wordCut(context, secondDesc, id.plus(29),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $firstDesc"
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $secondDesc",
            )
        )
    }

    //11.
    @RequiresApi(Build.VERSION_CODES.O)
    fun calcHPV(context: Context?, date: String, id: Int) {
        var vaccineName = "HPV"
        //6 weeks
        var firstDesc = getCalculatedDateK(date, 365)
        wordCut(context, firstDesc, id.plus(30),vaccineName)
        // 4 weeks
        var secondDesc = getCalculatedDateK(firstDesc, 180)
        wordCut(context, secondDesc, id.plus(31),vaccineName)
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $firstDesc"
            )
        )
        myArr.add(
            vaccineData(
                "vaccine Name : $vaccineName",
                " Dosage time : $secondDesc",
            )
        )
    }


    @SuppressLint("SimpleDateFormat")
    fun getCalculatedDateK(date: String, days: Int): String {
        val cal = Calendar.getInstance()
        val s = SimpleDateFormat("dd/MM/yyyy")
        if (date.isNotEmpty()) {
            cal.time = s.parse(date)
        }
        cal.add(Calendar.DAY_OF_YEAR, days)
        return s.format(Date(cal.timeInMillis))
    }


    fun startAlarm(context: Context?, year: Int, month: Int, days: Int, id: Int,message:String) {
        val intent = Intent(context, AlarmService::class.java)
        intent.putExtra("x",message)
        val am = context!!.getSystemService(ALARM_SERVICE1) as AlarmManager
        val cal = Calendar.getInstance()
        //Toast.makeText(context, "y=$year m=$month d=$days", Toast.LENGTH_SHORT).show()
        var mm =39
        //cal.set( year-0 ,month-1,days-0,4,mm)

        cal.set(Calendar.YEAR, year )
        cal.set(Calendar.MONTH, month - 1)
        cal.set(Calendar.HOUR_OF_DAY, 4)
        cal.set(Calendar.DAY_OF_MONTH,11)
        cal.set(Calendar.MINUTE, mm)
        cal.set(Calendar.SECOND, 0)
        am.set(
            AlarmManager.RTC_WAKEUP,
            cal.timeInMillis,
            PendingIntent.getBroadcast(
                context.applicationContext, id, intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        )


    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SimpleDateFormat")
    fun wordCut(context: Context?, date: String, id: Int,message:String) {
        val sf = SimpleDateFormat("yyyy")
        val sfm = SimpleDateFormat("MM")
        val sfd = SimpleDateFormat("dd")
        val d = Date()
        var day: Int = date[0].plus(date[1].toString()).toInt()
        var month: Int = date[3].plus(date[4].toString()).toInt()
        var year: Int =
            date[6].plus(date[7].toString()).plus(date[8].toString()).plus(date[9].toString())
                .toInt()
        val localDate = LocalDate.of(
            sf.format(d).toInt(), sfm.format(d).toInt(), sfd.format(d).toInt()
        )
        val start = LocalDate.of(year, month, day)
        if (localDate >= start) {
            return
        } else {
            startAlarm(context, year, month, day, id , message)
        }

    }


}

data class vaccineData(
    var vaccineName: String,
    var desc: String,

    )



