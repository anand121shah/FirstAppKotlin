package com.example.firstappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {


    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
//        val textView = findViewById<TextView>(R.id.tv).apply {
//            text = message
//        }

        webView = findViewById(R.id.wv)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        var url = "https://www.google.com/search?q="
        webView.loadUrl("$url + $message")

        fun onBackPressed() {
            if (webView.canGoBack())
                webView.goBack()
            else
                super.onBackPressed()
        }
    }
}
