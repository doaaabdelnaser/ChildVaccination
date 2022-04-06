package com.microgrezm.childvaccinatio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView

class LinksView : AppCompatActivity() {
    var title : TextView? = null
    var web : WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_links_view)
        title = findViewById(R.id.titelLink)
        web = findViewById(R.id.webVew)
       var t = intent.getStringExtra("lTitle")
       var l = intent.getStringExtra("link")
        title!!.text = t
        web!!.loadUrl(l!!)

    }
}