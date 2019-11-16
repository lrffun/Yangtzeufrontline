package com.example.yangtzeufrontline;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

public class Registe extends Activity {
    private WebView webView;
    private String registe_url = "https://www.baidu.com";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registe);
        webView = findViewById(R.id.registe);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(registe_url);
    }
}
