package com.violin.readingnews.news.news.newdetail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.webview.X5WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {
    @BindView(R.id.webview)
    X5WebView x5WebView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_activity);
        url = getIntent().getStringExtra("url");
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        x5WebView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if (x5WebView.canGoBack()) {
            x5WebView.goBack();
        } else
            super.onBackPressed();
    }

    public static void launch(Context context, String url) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }
}
