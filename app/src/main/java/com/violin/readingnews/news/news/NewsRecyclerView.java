package com.violin.readingnews.news.news;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whl on 2016/11/1.
 */

public class NewsRecyclerView extends RecyclerView {
    List<NewsBean> beanList;
    private NewsAdaper adapter;

    public NewsRecyclerView(Context context) {
        this(context, null);
    }

    public NewsRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        beanList = new ArrayList<>();
    }

    public void setNewsAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(manager);
        adapter = new NewsAdaper();
        setAdapter(adapter);
    }

    public void loadData(List<NewsBean> beans) {
        if (beans == null) {
            return;
        }
        beanList.clear();
        beanList.addAll(beans);
        adapter.notifyDataSetChanged();
    }

    class NewsAdaper extends RecyclerView.Adapter<NewsViewHolder> {

        @Override
        public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            NewsItemView itemView = new NewsItemView(parent.getContext());
            return new NewsViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(NewsViewHolder holder, int position) {
            NewsItemView view = (NewsItemView) holder.itemView;
            view.loadData(beanList.get(position));

        }

        @Override
        public int getItemCount() {
            return beanList == null ? 0 : beanList.size();
        }
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        public NewsViewHolder(View itemView) {
            super(itemView);
        }
    }

}
