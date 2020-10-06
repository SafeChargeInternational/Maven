package com.nuvei.cashiercardscannerexample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nuvei.cashiercardscanner.NuveiCashierCardScanner
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        NuveiCashierCardScanner.connect(webview, this)
        webview.clearCache(true)
        webview.clearHistory()
        webview.settings.javaScriptEnabled = true
        webview.loadUrl(intent.getStringExtra("url"))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NuveiCashierCardScanner.SCAN_CARD_REQUEST_CODE) {
            NuveiCashierCardScanner.didScan(data)
        }
    }
}
