package com.violin.readingnews.news.news.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.trackview.ColorTrackView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsHomeFragment extends Fragment implements ViewPager.OnPageChangeListener {


    @BindView(R.id.viewpager)
    NewsHomeViewPager homeViewPager;
    @BindViews({R.id.id_tab_01, R.id.id_tab_02, R.id.id_tab_03})
    List<ColorTrackView> tabs;

    private View view;

    public NewsHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.news_home_fragment, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        homeViewPager.addOnPageChangeListener(this);
        homeViewPager.setMainAdapter();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        homeViewPager.removeOnPageChangeListener(this);
        super.onDestroyView();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0&&position<tabs.size()) {
            ColorTrackView left = tabs.get(position);

            ColorTrackView right = tabs.get(position + 1);
            left.setDirection(1);
            right.setDirection(0);
            Log.e("TAG", positionOffset + "");
            left.setProgress(1 - positionOffset);
            right.setProgress(positionOffset);
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
