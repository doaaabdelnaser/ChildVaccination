package com.microgrezm.childvaccinatio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*

class FirstLogin : AppCompatActivity() {
    var nextButton: ImageButton? = null
    var skip: TextView? = null
    var imageSwitcher: ImageSwitcher? = null
    var myArr = arrayOf(
        R.drawable.i1,
        R.drawable.i2,
        R.drawable.i3,
        R.drawable.i4,

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_login)
        nextButton = findViewById(R.id.nextBTN)
        imageSwitcher = findViewById(R.id.imageSwitcher)
        skip = findViewById(R.id.skipTV)
        imageSwitcher!!.setFactory {
            // var imageView = ImageView(this@FirstLogin)
            // imageView.scaleType = ImageView.ScaleType.FIT_XY


            val imageView = ImageView(applicationContext)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            imageView.layoutParams =
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )



            imageView
        }
        val aniIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        val aniOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
        imageSwitcher!!.inAnimation = aniIn
        imageSwitcher!!.outAnimation = aniOut
        var index = 0
        imageSwitcher!!.setImageResource(myArr[index])
        nextButton!!.setOnClickListener {
            index++
            if (index >= myArr.size) {
                val intent = Intent(this, MainView::class.java)
                intent.putExtra("activity", "first log")
                startActivity(intent)
                this.finish()
            } else {
                imageSwitcher!!.setImageResource(myArr[index])
            }
        }

        skip!!.setOnClickListener {
            val intent = Intent(this, MainView::class.java)
            intent.putExtra("activity", "first log")
            startActivity(intent)
            this.finish()
        }
    }
}