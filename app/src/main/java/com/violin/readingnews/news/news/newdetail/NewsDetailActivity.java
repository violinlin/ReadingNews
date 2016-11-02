package com.violin.readingnews.news.news.newdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.systemBar.SysBar;
import com.violin.readingnews.kit.webview.X5WebView;
import com.violin.readingnews.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {
    @BindView(R.id.webview)
    X5WebView x5WebView;
    private String url;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_activity);
        SysBar.applyTint(this);
        url = getIntent().getStringExtra("url");
        ButterKnife.bind(this);
        initToobar();
        initView();
    }

    private void initToobar() {
//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            toolbar.setPadding(0, Util.getSysStatusHeight(this), 0, 0);
        }
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x5WebView.canGoBack()) {
                    x5WebView.goBack();
                } else {
                    NewsDetailActivity.this.finish();
                }
            }
        });
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
