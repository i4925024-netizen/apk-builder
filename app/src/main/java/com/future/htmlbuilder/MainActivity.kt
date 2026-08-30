package com.future.htmlbuilder

import android.app.*
import android.os.Bundle
import android.webkit.*
import android.widget.*
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebViewAssetLoader

class MainActivity : AppCompatActivity() {
 private lateinit var web: WebView
 override fun onCreate(b: Bundle?) { super.onCreate(b); web=WebView(this); setContentView(web); setup(); web.loadUrl("https://appassets.androidplatform.net/assets/index.html") }
 private fun setup(){
  WebView.setWebContentsDebuggingEnabled(true)
  web.settings.javaScriptEnabled=true; web.settings.domStorageEnabled=true; web.settings.allowFileAccess=false; web.settings.allowContentAccess=false
  web.webViewClient=WebViewClient(); web.webChromeClient=WebChromeClient()
  web.addJavascriptInterface(Bridge(),"Android")
 }
 inner class Bridge {
  @JavascriptInterface fun getPlatform():String="Android"
  @JavascriptInterface fun showMessage(s:String){runOnUiThread{Toast.makeText(this@MainActivity,s,Toast.LENGTH_SHORT).show()}}
 }
 override fun onBackPressed(){ if(web.canGoBack()) web.goBack() else super.onBackPressed() }
}
