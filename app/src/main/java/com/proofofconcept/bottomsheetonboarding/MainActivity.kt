package com.proofofconcept.bottomsheetonboarding

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val animationHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animationHandler.post(object : Runnable {
            override fun run() {
                hopAnimation()
                animationHandler.postDelayed(this, 1000)
            }
        })
    }

    private fun hopAnimation() {
        val animation = linearLayoutBottomSheet
            .animate()
            .translationYBy(-40f)
            .setDuration(200)
        animation.withEndAction {
            linearLayoutBottomSheet.animate().translationYBy(40f).duration = 200
        }
    }
}
