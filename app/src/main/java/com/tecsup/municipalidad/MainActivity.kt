package com.tecsup.municipalidad


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.tecsup.municipalidad.reportes.InformationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this,
                InformationActivity::class.java
            )
            )
            finish()

        }, 1000)

        supportActionBar?.hide()
    }
}