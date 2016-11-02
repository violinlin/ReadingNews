package com.violin.readingnews.news.news.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.violin.readingnews.kit.vpcontrol.ItemCyclerControl;
import com.violin.readingnews.news.joke.PicFragment;
import com.violin.readingnews.news.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whl on 2016/11/1.
 */

public class NewsHomeViewPager extends ViewPager {
    public NewsHomeViewPager(Context context) {
        this(context, null);
    }

    public NewsHomeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void setMainAdapter() {
        List<View> views = new ArrayList<>();
        views.add(new TextView(getContext()));
        views.add(new TextView(getContext()));
        views.add(new TextView(getContext()));
        MainVPAdapter adapter = new MainVPAdapter();
        adapter.setViews(views);

//        监听ViewPager的滑动生命周期
//        ItemCyclerControl itemCyclerControl = new ItemCyclerControl();
//        itemCyclerControl.setupWithItemList(fragments);
//        itemCyclerControl.setupWithViewPager(this);

        setAdapter(adapter);
    }

    class MainVPAdapter extends PagerAdapter {
        private List<View> views;

        public void setViews(List<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            return views == null ? 0 : views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));

        }
    }
}
