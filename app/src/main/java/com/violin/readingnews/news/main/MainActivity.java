package com.violin.readingnews.news.main;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.systemBar.SysBar;
import com.violin.readingnews.news.news.NewsBean;
import com.violin.readingnews.utils.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavView.SwitchListener {


    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.navview)
    NavView navView;
    @BindView(R.id.viewpager)
    MainViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SysBar.applyTint(this);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        initToobar();
        initView();
    }

    private void initView() {
        navView.setOnSwitchListener(this);
        viewPager.setMainAdapter(getSupportFragmentManager());
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    private void initToobar() {
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
    public void currentPosition(int position) {
        Log.d("whl", "position" + position);
        viewPager.setCurrentItem(position - 1);
    }
}
