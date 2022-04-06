package com.microgrezm.childvaccinatio

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.microgrezm.childvaccination.data.ChildData
import com.microgrezm.childvaccination.database.ChildDatabase
import com.microgrezm.childvaccination.database.LocalRepositoryIpm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

class AddFragment : Fragment() {
    var nameEt: EditText? = null
    var calendarIBTN: ImageButton? = null
    var addBTN: ImageButton? = null
    var calendarTV: TextView? = null
    var boy: RadioButton? = null

    var girl: RadioButton? = null

    lateinit var localRepositoryIpm: LocalRepositoryIpm
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_add, container, false)
        sharedPreferences =
            this.requireActivity().getSharedPreferences("get_id", Context.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        var childId = sharedPreferences!!.getInt("id", 1)
        nameEt = v.findViewById(R.id.nameET)
        calendarIBTN = v.findViewById(R.id.calendarIBTN)
        addBTN = v.findViewById(R.id.addBTN)
        calendarTV = v.findViewById(R.id.calendarTV)
        boy = v.findViewById(R.id.maleRBTN)
        girl = v.findViewById(R.id.femaleRBTN)
        // rvt= v.findViewById(R.id.rctest)
        var birthDay: String = ""
        val d = Date()
        calendarIBTN!!.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                    var m = month
                    var daa = dayOfMonth
                    var mo: String
                    var da: String
                    if (m <= 8) {
                        mo = "0${m + 1}"
                    } else {
                        mo = "${m + 1}"
                    }
                    if (daa < 10) {
                        da = "0$daa"
                    } else {
                        da = "$daa"
                    }

                    birthDay = "$da/$mo/$year"
                  if (birthDay == ""|| birthDay.isEmpty()){
                      return@OnDateSetListener
                  }else {
                      val sf = SimpleDateFormat("yyyy")
                      val sfm = SimpleDateFormat("MM")
                      val sfd = SimpleDateFormat("dd")

                      var day1: Int = dayOfMonth.toInt()
                      var month1: Int = mo.toInt()
                      var year1: Int = year
                      val localDate = LocalDate.of(
                          sf.format(d).toInt(), sfm.format(d).toInt(), sfd.format(d).toInt()
                      )

                      val start = LocalDate.of(year1,month1,day1)
                      val years = ChronoUnit.YEARS.between(start,localDate)
                    if (localDate < start ||years >=5   ) {
                        Toast.makeText(context, "incorrect date ", Toast.LENGTH_SHORT).show()
                        calendarTV!!.text = "incorrect date"
                        return@OnDateSetListener
                    }else{
                        calendarTV!!.text = birthDay.toString()
                    } }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            ).show()
                }

        addBTN!!.setOnClickListener {
            //  if (nameEt.text == "")
            var name = nameEt!!.text.toString()
            var gender: String
            if (boy!!.isChecked) {
                boy!!.isChecked = false

                gender = "boy"
            } else if (girl!!.isChecked) {
                gender = "girl"
                girl!!.isChecked = false
            } else {
                Toast.makeText(context, "please select the gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (name.isEmpty()) {
                Toast.makeText(context, "please enter the child name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (birthDay!!.isEmpty()) {
                Toast.makeText(context, "Please select the birth day ", Toast.LENGTH_SHORT).show()
            }
            nameEt!!.setText("")
            calendarTV!!.text = ""
            var dbR = ChildDatabase.getInstance(requireContext())
            localRepositoryIpm = LocalRepositoryIpm(dbR)
            childId++
            editor!!.putInt("id", childId)
            var calc = Calc()
            var arr = calc.calcALL(requireContext(), birthDay!!, childId)

            // add the room data base
            GlobalScope.launch(Dispatchers.IO) {

                localRepositoryIpm.childInsert(
                    ChildData(
                        childId, name, gender, birthDay!!,
                        "${arr[0].vaccineName} , ${arr[0].desc}",
                        "${arr[1].vaccineName} , ${arr[1].desc}",
                        "${arr[2].vaccineName} , ${arr[2].desc}",
                        "${arr[3].vaccineName} , ${arr[3].desc}",
                        "${arr[4].vaccineName} , ${arr[4].desc}",
                        "${arr[5].vaccineName} , ${arr[5].desc}",
                        "${arr[6].vaccineName} , ${arr[6].desc}",
                        "${arr[7].vaccineName} , ${arr[7].desc}",
                        "${arr[8].vaccineName} , ${arr[8].desc}",
                        "${arr[9].vaccineName} , ${arr[9].desc}",
                        "${arr[10].vaccineName} , ${arr[10].desc}",
                        "${arr[11].vaccineName} , ${arr[11].desc}",
                        "${arr[12].vaccineName} , ${arr[12].desc}",
                        "${arr[13].vaccineName} , ${arr[13].desc}",
                        "${arr[14].vaccineName} , ${arr[14].desc}",
                        "${arr[15].vaccineName} , ${arr[15].desc}",
                        "${arr[16].vaccineName} , ${arr[16].desc}",
                        "${arr[17].vaccineName} , ${arr[17].desc}",
                        "${arr[18].vaccineName} , ${arr[18].desc}",
                        "${arr[19].vaccineName} , ${arr[19].desc}",
                        "${arr[20].vaccineName} , ${arr[20].desc}",
                        "${arr[21].vaccineName} , ${arr[21].desc}",
                        "${arr[22].vaccineName} , ${arr[22].desc}",
                        "${arr[23].vaccineName} , ${arr[23].desc}",
                        "${arr[24].vaccineName} , ${arr[24].desc}",
                        "${arr[25].vaccineName} , ${arr[25].desc}",
                        "${arr[26].vaccineName} , ${arr[26].desc}",
                        "${arr[27].vaccineName} , ${arr[27].desc}",
                        "${arr[28].vaccineName} , ${arr[28].desc}",
                        "${arr[29].vaccineName} , ${arr[29].desc}",
                        "${arr[30].vaccineName} , ${arr[30].desc}",
                    )
                )
            }
            editor!!.apply()
            Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
            val fragment: Fragment = ListFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
                    }
        return v
    }
   }