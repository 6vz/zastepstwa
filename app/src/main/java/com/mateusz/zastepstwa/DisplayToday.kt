package com.mateusz.zastepstwa

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class DisplayToday : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_today)
        // get today's month and day
        val month = java.time.LocalDate.now().monthValue
        val day = java.time.LocalDate.now().dayOfMonth
        val year = java.time.LocalDate.now().year
        println("month: $month, day: $day, year: $year")
        // get the url from the intent
        val url = intent.getStringExtra("pdf_url")
        val webView = findViewById<WebView>(R.id.web)
        webView.webViewClient = WebViewClient()
        
        webView.loadUrl("$url")
    }
}