package com.violin.readingnews.news.joke;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.violin.readingnews.R;
import com.violin.readingnews.kit.image.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public PicItemView(Context context) {
        this(context, null);
    }

    public PicItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(LinearLayout.VERTICAL);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setLayoutParams(params);
        inflate(getContext(),R.layout.pic_item_layout,this);
        ButterKnife.bind(this, this);
    }

    public void loadData(PicBean picBean) {
        titleTV.setText(picBean.getContent());
        ImageUtils.loadImage(getContext(), picBean.getUrl(), imageView);
        dateTV.setText(picBean.getUpdatetime());

    }
}
