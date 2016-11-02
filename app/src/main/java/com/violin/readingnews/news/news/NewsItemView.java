package com.violin.readingnews.news.news;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.image.ImageUtils;
import com.violin.readingnews.news.news.newdetail.NewsDetailActivity;
import com.violin.readingnews.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        setBackgroundColor(Color.parseColor("#ffffff"));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.CENTER_VERTICAL);
        params.setMargins(Util.dp2px(context, 0), Util.dp2px(context, 10), Util.dp2px(context, 0), Util.dp2px(context, 10));
        setLayoutParams(params);
        setPadding(Util.dp2px(context, 10), Util.dp2px(context, 10), Util.dp2px(context, 10), Util.dp2px(context, 10));
        inflate(context, R.layout.news_item_view, this);
        this.setOnClickListener(this);
        ButterKnife.bind(this, this);
    }

    public void loadData(NewsBean bean) {
        newsBean = bean;
        tv_title.setText(bean.getTitle());
        ImageUtils.loadImage(getContext(), bean.getThumbnail_pic_s(), imageView);
        tv_des.setText(bean.getAuthor_name()+"   "+bean.getDate());

    }

    @OnClick(R.id.imageview)
    public void onImageViewClick(ImageView imageView) {
        ImageUtils.ImageState state = (ImageUtils.ImageState) imageView.getTag(ImageUtils.TAG_KEY);
        switch (state) {
            case loading:
            case success:
                break;
            case error:
                ImageUtils.loadImage(getContext(), newsBean.getThumbnail_pic_s(), imageView);
                break;
        }


    }

    @Override
    public void onClick(View v) {
        NewsDetailActivity.launch(getContext(), newsBean.getUrl());

    }

}
