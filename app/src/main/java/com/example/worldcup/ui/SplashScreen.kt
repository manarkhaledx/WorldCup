package com.example.worldcup.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.worldcup.R

class SplashScreenActivity : AppCompatActivity() {
    private val splashDuration = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Optionally, make the navigation bar transparent as well
        // window.navigationBarColor = Color.TRANSPARENT

        setContentView(R.layout.activity_splash_screen)

        val runnable = Runnable {
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        window.decorView.postDelayed(runnable, splashDuration)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        window.decorView.removeCallbacks(null)
        super.onBackPressed()
    }
}
