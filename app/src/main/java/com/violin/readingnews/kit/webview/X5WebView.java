package com.violin.readingnews.kit.webview;

import android.content.Context;
import android.util.AttributeSet;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created by whl on 2016/10/26.
 */

public class X5WebView extends WebView {
    private WebViewClient client = new WebViewClient() {
        /**
         * 防止加载网页时调取系统的浏览器
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
            webView.loadUrl(s);
            return true;
        }
    };
    private WebChromeClient chromeClient = new WebChromeClient() {
//        TODO 设置WebChromeClient

    };

    public X5WebView(Context context) {
        this(context, null);
    }

    public X5WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWebViewClient(client);
        setWebChromeClient(chromeClient);
        initWebSetting();
    }

    /**
     * WebSettings的设置
     */
    private void initWebSetting() {
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);//设置webview支持js脚本
        webSettings.setLoadsImagesAutomatically(true);//支持自动加载图片
        webSettings.setUseWideViewPort(true);//设置界面自适应屏幕
        webSettings.setSupportZoom(true);//设置支持缩放
    }
}
