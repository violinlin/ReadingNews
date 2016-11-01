package com.violin.readingnews.news.news;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.violin.readingnews.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements NewsContract.View {

    @BindView(R.id.recyclerview)
    NewsRecyclerView recyclerView;
    private View view;
    private NewsPresenter newsPresenter;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.news_fragment, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        initMVP();
        return view;
    }

    private void initMVP() {
        newsPresenter = new NewsPresenter();
        newsPresenter.setView(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsPresenter.requestNewsData("index", "top");
    }

    private void initView(View view) {
        recyclerView.setNewsAdapter();
    }


    @Override
    public void upDateNewsList(List<NewsBean> beanList) {
        recyclerView.loadData(beanList);

    }


}
