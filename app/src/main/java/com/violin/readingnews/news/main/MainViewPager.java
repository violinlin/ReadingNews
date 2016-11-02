package com.violin.readingnews.news.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.violin.readingnews.kit.vpcontrol.ItemCyclerControl;
import com.violin.readingnews.news.joke.PicFragment;
import com.violin.readingnews.news.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whl on 2016/11/1.
 */

public class MainViewPager extends ViewPager {
    public MainViewPager(Context context) {
        this(context, null);
    }

    public MainViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOffscreenPageLimit(4);

    }

    public void setMainAdapter(FragmentManager manager) {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new PicFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        MainVPAdapter adapter = new MainVPAdapter(manager);
        adapter.setFragments(fragments);

//        监听ViewPager的滑动生命周期
        ItemCyclerControl itemCyclerControl = new ItemCyclerControl();
        itemCyclerControl.setupWithItemList(fragments);
        itemCyclerControl.setupWithViewPager(this);

        setAdapter(adapter);
    }

    class MainVPAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments;

        public void setFragments(List<Fragment> fragments) {
            this.fragments = fragments;
        }

        public MainVPAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments == null ? 0 : fragments.size();
        }
    }
}
