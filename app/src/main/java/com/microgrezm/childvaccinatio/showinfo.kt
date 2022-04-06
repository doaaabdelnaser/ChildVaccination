package com.microgrezm.childvaccinatio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class showinfo : AppCompatActivity() {
    var title: TextView? = null
    var body: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showinfo)
        title = findViewById(R.id.TitleTextView)
        body = findViewById(R.id.BadyTextView)
        var t = intent.getStringExtra("title")
        var b = intent.getStringExtra("body")
        title!!.text = t
        body!!.text = b
    }
}