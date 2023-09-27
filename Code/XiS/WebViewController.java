package com.example.xis;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// class is extended to WebViewClient to access the WebView
public class WebViewController extends WebViewClient {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // loadurl function will load the
        // url we will provide to our webview

        view.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");

        view.evaluateJavascript("document.querySelector('meta[name=\"viewport\"]').setAttribute('content', 'width=1024px, initial-scale=' + (document.documentElement.clientWidth / 1024));", null);


        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setLoadWithOverviewMode(true);
        view.getSettings().setUseWideViewPort(true);

        view.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        view.getSettings().setSupportZoom(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setDisplayZoomControls(false);

        view.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        view.setScrollbarFadingEnabled(false);
        setDesktopMode(view, true);
        view.loadUrl(url);

        return true;
    }

    public void setDesktopMode(WebView webView,boolean enabled) {
        String newUserAgent = webView.getSettings().getUserAgentString();
        if (enabled) {
            try {
                String ua = webView.getSettings().getUserAgentString();
                String androidOSString = webView.getSettings().getUserAgentString().substring(ua.indexOf("("), ua.indexOf(")") + 1);
                newUserAgent = webView.getSettings().getUserAgentString().replace(androidOSString, "(X11; Linux x86_64)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            newUserAgent = null;
        }

        webView.getSettings().setUserAgentString(newUserAgent);
        webView.getSettings().setUseWideViewPort(enabled);
        webView.getSettings().setLoadWithOverviewMode(enabled);
        webView.reload();
    }


}


