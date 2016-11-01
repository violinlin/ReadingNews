package com.violin.readingnews.news.news;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.violin.readingnews.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by whl on 2016/11/1.
 */

public class NewsItemView extends LinearLayout {
    @BindView(R.id.title)
    TextView tv_title;
    @BindViews({R.id.imageview1, R.id.imageview2, R.id.imageview3})
    List<ImageView> imageViews;

    public NewsItemView(Context context) {
        this(context, null);
    }

    public NewsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(LinearLayout.VERTICAL);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        inflate(context, R.layout.news_item_view, this);
        ButterKnife.bind(this, this);
    }

    public void loadData(NewsBean bean) {
        tv_title.setText(bean.getTitle());

    }
}
