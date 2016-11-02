package com.violin.readingnews.news.joke;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.image.ImageUtils;
import com.violin.readingnews.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.violin.readingnews.kit.image.ImageUtils.ImageState.*;
import static com.violin.readingnews.kit.image.ImageUtils.TAG_KEY;

/**
 * Created by whl on 2016/11/1.
 */

public class PicItemView extends LinearLayout {
    @BindView(R.id.title)
    TextView titleTV;
    @BindView(R.id.imageview)
    ImageView imageView;
    @BindView(R.id.date)
    TextView dateTV;
    private PicBean picBean;

    public PicItemView(Context context) {
        this(context, null);
    }

    public PicItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(LinearLayout.VERTICAL);
        this.setBackgroundColor(Color.parseColor("#ffffff"));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(Util.dp2px(context, 0), Util.dp2px(context, 10), Util.dp2px(context, 0), Util.dp2px(context, 10));
        setGravity(Gravity.CENTER_HORIZONTAL);
        setLayoutParams(params);
        setPadding(Util.dp2px(context, 10), Util.dp2px(context, 10), Util.dp2px(context, 10), Util.dp2px(context, 10));
        inflate(getContext(), R.layout.pic_item_layout, this);
        ButterKnife.bind(this, this);
    }

    @OnClick(R.id.imageview)
    public void onImageViewClick(ImageView imageView) {
        ImageUtils.ImageState state = (ImageUtils.ImageState) imageView.getTag(TAG_KEY);

        switch (state) {
            case loading:
            case success:
                break;
            case error:
                ImageUtils.loadImage(getContext(), picBean.getUrl(), imageView);
                break;


        }

    }

    public void loadData(PicBean picBean) {
        titleTV.setText(picBean.getContent());
        ImageUtils.loadImage(getContext(), picBean.getUrl(), imageView);
        dateTV.setText(picBean.getUpdatetime());
        this.picBean = picBean;
    }
}
