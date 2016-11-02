package com.violin.readingnews.news.joke;

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

public class PicRecyclerView extends RecyclerView {
    private List<PicBean> picBeanList;
    private PicAdapter adapter;

    public PicRecyclerView(Context context) {
        this(context, null);
    }

    public PicRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        picBeanList = new ArrayList<>();
        setPicAdapter();
    }

    public void setPicAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(manager);
        adapter = new PicAdapter();
        setAdapter(adapter);

    }

    public void loadData(List<PicBean> picBeanList) {
        if (picBeanList == null) {
            return;
        }
        this.picBeanList.clear();
        this.picBeanList.addAll(picBeanList);
        adapter.notifyDataSetChanged();

    }

    class PicAdapter extends RecyclerView.Adapter<PicViewHolder> {

        @Override
        public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            PicItemView itemView = new PicItemView(parent.getContext());
            return new PicViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(PicViewHolder holder, int position) {
            PicItemView itemView = (PicItemView) holder.itemView;
            itemView.loadData(picBeanList.get(position));

        }

        @Override
        public int getItemCount() {
            return picBeanList == null ? 0 : picBeanList.size();
        }
    }

    class PicViewHolder extends RecyclerView.ViewHolder {

        public PicViewHolder(View itemView) {
            super(itemView);
        }
    }


}
