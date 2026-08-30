package com.future.aihtml

import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity(){
 private lateinit var web:WebView
 override fun onCreate(b:Bundle?){super.onCreate(b);web=WebView(this);setContentView(web);web.settings.javaScriptEnabled=true;web.settings.domStorageEnabled=true;web.webViewClient=WebViewClient();web.webChromeClient=WebChromeClient();web.addJavascriptInterface(Bridge(),"Android");web.loadUrl("file:///android_asset/index.html")}
 inner class Bridge{
  @JavascriptInterface fun platform()="Android"
  @JavascriptInterface fun toast(s:String){runOnUiThread{Toast.makeText(this@MainActivity,s,Toast.LENGTH_SHORT).show()}}
 }
 override fun onBackPressed(){if(web.canGoBack())web.goBack()else super.onBackPressed()}
}
