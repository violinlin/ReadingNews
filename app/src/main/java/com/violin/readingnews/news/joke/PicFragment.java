package com.violin.readingnews.news.joke;


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
public class PicFragment extends Fragment implements PicContract.View {

    @BindView(R.id.recyclerview)
    PicRecyclerView picRecyclerView;
    private PicPresenter presenter;

    public PicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.pic_fragment, container, false);
        ButterKnife.bind(this, view);
        initMVP();
        initView();
        return view;
    }

    private void initView() {

    }

    private void initMVP() {
        presenter = new PicPresenter();
        presenter.setView(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.requestData();
    }

    @Override
    public void updateJokeList(List<PicBean> beanList) {
        picRecyclerView.loadData(beanList);
    }
}
