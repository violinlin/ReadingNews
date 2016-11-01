package com.violin.readingnews.news.news;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.image.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by whl on 2016/11/1.
 */

public class NewsItemView extends LinearLayout implements View.OnClickListener {
    @BindView(R.id.title)
    TextView tv_title;
    @BindView(R.id.imageview)
    ImageView imageView;
    @BindView(R.id.short_des)
    TextView tv_des;
    NewsBean newsBean;

    public NewsItemView(Context context) {
        this(context, null);
    }

    public NewsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.CENTER_VERTICAL);
        setLayoutParams(params);
        inflate(context, R.layout.news_item_view, this);
        ButterKnife.bind(this, this);
    }

    public void loadData(NewsBean bean) {
        newsBean=bean;
        tv_title.setText(bean.getTitle());
        ImageUtils.loadImage(getContext(), bean.getThumbnail_pic_s(), imageView);
        tv_des.setText(bean.getAuthor_name());

    }

    @Override
    public void onClick(View v) {

    }
}
