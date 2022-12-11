package com.mateusz.zastepstwa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        // always force light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todayButton = findViewById<Button>(R.id.triggerToday)
        val tomorrowButton = findViewById<Button>(R.id.triggerNextDay)
        if (java.time.LocalDate.now().dayOfWeek.value > 5) {
            val dayToday = java.time.LocalDate.now().dayOfMonth
            val monthToday = java.time.LocalDate.now().monthValue
            val yearToday = java.time.LocalDate.now().year
            todayButton.isEnabled = false
            todayButton.text = "Dzień poza planem ($dayToday.$monthToday.$yearToday)"
        } else {
            val dayToday = java.time.LocalDate.now().dayOfMonth
            val monthToday = java.time.LocalDate.now().monthValue
            val yearToday = java.time.LocalDate.now().year
            todayButton.text = "Dzisiaj ($dayToday.$monthToday.$yearToday)"
        }
        if (java.time.LocalDate.now().plusDays(1).dayOfWeek.value > 5) {
            val dayTomorrow = java.time.LocalDate.now().plusDays(1).dayOfMonth
            val monthTomorrow = java.time.LocalDate.now().plusDays(1).monthValue
            val yearTomorrow = java.time.LocalDate.now().plusDays(1).year
            tomorrowButton.isEnabled = false
            tomorrowButton.text = "Dzień poza planem ($dayTomorrow.$monthTomorrow.$yearTomorrow)"
        } else {
            val dayTomorrow = java.time.LocalDate.now().plusDays(1).dayOfMonth
            val monthTomorrow = java.time.LocalDate.now().plusDays(1).monthValue
            val yearTomorrow = java.time.LocalDate.now().plusDays(1).year
            tomorrowButton.text = "Jutro ($dayTomorrow.$monthTomorrow.$yearTomorrow)"
        }
        todayButton.setOnClickListener {
            val intent = Intent(this, DisplayToday::class.java)
            val month = java.time.LocalDate.now().monthValue
            val day = java.time.LocalDate.now().dayOfMonth
            if (day.toString().length == 1) {
                println("Getting values for 0$day.$month")
                intent.putExtra(
                    "pdf_url",
                    "https://zst.6vz.dev/get?day=0$day&month=$month&nocache=1"
                )
            } else {
                println("Getting values for $day.$month")
                intent.putExtra(
                    "pdf_url",
                    "https://zst.6vz.dev/get?day=$day&month=$month&nocache=1"
                )
            }
            startActivity(intent)
        }
        tomorrowButton.setOnClickListener {
            val intent = Intent(this, DisplayToday::class.java)
            val month = java.time.LocalDate.now().plusDays(1).monthValue
            val day = java.time.LocalDate.now().plusDays(1).dayOfMonth
            if (day.toString().length == 1) {
                println("Getting values for 0$day.$month")
                intent.putExtra(
                    "pdf_url",
                    "https://zst.6vz.dev/get?day=0$day&month=$month&nocache=1"
                )
            } else {
                println("Getting values for $day.$month")
                intent.putExtra(
                    "pdf_url",
                    "https://zst.6vz.dev/get?day=$day&month=$month&nocache=1"
                )
            }
            startActivity(intent)
        }
    }
}