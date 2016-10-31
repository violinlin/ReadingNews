package com.violin.readingnews.news.main;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.systemBar.SysBar;
import com.violin.readingnews.utils.Util;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SysBar.applyTint(this);
        setContentView(R.layout.main_activity);
        initMVP();
        initToobar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initMVP() {
        mPresenter = new MainPresenter();
        mPresenter.setView(this);
        mPresenter.requestData("index", "top");
    }

    private void initToobar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            AppBarLayout.LayoutParams pa = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
            pa.setMargins(0, Util.getSysStatusHeight(this), 0, 0);
            toolbar.setLayoutParams(pa);
        }

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Override
    public void updateNewsList() {
        Toast.makeText(getBaseContext(), "返回数据成功", Toast.LENGTH_SHORT).show();
    }
}
