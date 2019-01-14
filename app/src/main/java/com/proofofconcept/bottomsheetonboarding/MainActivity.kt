package com.proofofconcept.bottomsheetonboarding

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val animationHandler = Handler()
    private lateinit var animationRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animationRunnable = Runnable { animationFunction() }
        animationHandler.post(animationRunnable)
    }

    private fun animationFunction() {
        val animation = linearLayoutBottomSheet
            .animate()
            .translationYBy(-40f)
            .setDuration(200)
        animation.withEndAction {
            linearLayoutBottomSheet.animate().translationYBy(40f).duration = 200
        }
        animationHandler.postDelayed(animationRunnable, 1000)
    }
}
