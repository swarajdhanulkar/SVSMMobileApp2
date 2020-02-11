package com.sdapp.svsmmobileapp;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import dmax.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertDialog = new SpotsDialog
                .Builder()
                .setContext(this)
                .setMessage("Please Wait")
                .setCancelable(false)
                .build();

        alertDialog.show();

        webView = findViewById(R.id.browser);
        webView.setWebViewClient(new MyBowser());



        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("http://svsm.procohat.tech/register/1");


    }
    class MyBowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            alertDialog.dismiss();
        }
    }

}

