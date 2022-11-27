package com.mateusz.zastepstwa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todayButton = findViewById<Button>(R.id.triggerToday)
        val tomorrowButton = findViewById<Button>(R.id.triggerNextDay)
        if (java.time.LocalDate.now().dayOfWeek.value > 5) {
            val day_e = java.time.LocalDate.now().dayOfMonth
            val month_e = java.time.LocalDate.now().monthValue
            val year_e = java.time.LocalDate.now().year
            todayButton.isEnabled = false
            todayButton.text = "Dzień poza planem ($day_e.$month_e.$year_e)"
        } else {
            val day_e = java.time.LocalDate.now().dayOfMonth
            val month_e = java.time.LocalDate.now().monthValue
            val year_e = java.time.LocalDate.now().year
            todayButton.text = "Dzisiaj ($day_e.$month_e.$year_e)"
        }
        if (java.time.LocalDate.now().plusDays(1).dayOfWeek.value > 5) {
            val day_t = java.time.LocalDate.now().plusDays(1).dayOfMonth
            val month_t = java.time.LocalDate.now().plusDays(1).monthValue
            val year_t = java.time.LocalDate.now().plusDays(1).year
            tomorrowButton.isEnabled = false
            tomorrowButton.text = "Dzień poza planem ($day_t.$month_t.$year_t)"
        } else {
            val day_t = java.time.LocalDate.now().plusDays(1).dayOfMonth
            val month_t = java.time.LocalDate.now().plusDays(1).monthValue
            val year_t = java.time.LocalDate.now().plusDays(1).year
            tomorrowButton.text = "Jutro ($day_t.$month_t.$year_t)"
        }
        todayButton.setOnClickListener {
            val intent = Intent(this, DisplayToday::class.java)
            val month = java.time.LocalDate.now().monthValue
            val day = java.time.LocalDate.now().dayOfMonth
            intent.putExtra("pdf_url", "https://zst.6vz.dev/get?day=$day&month=$month")
            startActivity(intent)
        }
        tomorrowButton.setOnClickListener {
            val intent = Intent(this, DisplayToday::class.java)
            val month = java.time.LocalDate.now().plusDays(1).monthValue
            val day = java.time.LocalDate.now().plusDays(1).dayOfMonth
            intent.putExtra("pdf_url", "https://zst.6vz.dev/get?day=$day&month=$month")
            startActivity(intent)
        }
    }
}