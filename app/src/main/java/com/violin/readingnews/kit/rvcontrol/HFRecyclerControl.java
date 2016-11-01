package com.violin.readingnews.kit.rvcontrol;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.violin.readingnews.R;


/**
 * Created by lizeng on 16/3/18.
 */
public class HFRecyclerControl {

    private RecyclerView recyclerView;
    private HFRecyclerAdapter hfAdapter;

    public HFRecyclerControl() {
        hfAdapter = new HFRecyclerAdapter();
    }

    public void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        this.recyclerView = recyclerView;
        hfAdapter.setAdapter(adapter);
        recyclerView.setAdapter(hfAdapter);

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup lookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (hfAdapter.isHeader(position) || hfAdapter.isFooter(position)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return lookup.getSpanSize(position - hfAdapter.getHeaderViewsCount());
                }
            });
        }
    }

    public void removeHeaderView(View view) {
        hfAdapter.removeHeaderView(view);
    }

    public void addHeaderView(View view) {
        hfAdapter.addHeaderView(view);
    }

    public void addHeaderView(int index, View view) {
        hfAdapter.addHeaderView(index, view);
    }

    public void removeFooterView(View view) {
        hfAdapter.removeFooterView(view);
    }

    public void addFooterView(View view) {
        hfAdapter.addFooterView(view);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    /**
     * 请使用本方法替代RecyclerView.ViewHolder的getLayoutPosition()方法
     *
     * @param holder
     * @return
     */
    public static int getLayoutPosition(RecyclerView.ViewHolder holder) {
        Object tag = holder.itemView.getTag(R.id.hfrecycler_item_tag);
        if (tag != null && tag instanceof HFRecyclerAdapter) {
            return holder.getLayoutPosition() - ((HFRecyclerAdapter) tag).getHeaderViewsCount();
        }
        return holder.getLayoutPosition();
    }

    /**
     * 请使用本方法替代RecyclerView.ViewHolder的getAdapterPosition()方法
     *
     * @param holder
     * @return
     */
    public static int getAdapterPosition(RecyclerView.ViewHolder holder) {
        Object tag = holder.itemView.getTag(R.id.hfrecycler_item_tag);
        if (tag != null && tag instanceof HFRecyclerAdapter) {
            return holder.getAdapterPosition() - ((HFRecyclerAdapter) tag).getHeaderViewsCount();
        }
        return holder.getAdapterPosition();
    }
}
