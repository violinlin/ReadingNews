package com.violin.readingnews.news.main;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.violin.readingnews.R;

/**
 * Created by whl on 2016/11/1.
 */

public class NavView extends RadioGroup implements RadioGroup.OnCheckedChangeListener {
    private SwitchListener switchListener;

    public NavView(Context context) {
        this(context, null);
    }

    public NavView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.main_nav_layout, this);
        setOnCheckedChangeListener(this);
    }

    public void setOnSwitchListener(SwitchListener switchListener) {
        this.switchListener = switchListener;

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (switchListener == null) {
            return;
        }
        //如果不给RadioButton设置id,checkdId返回的是他么所在的位置:1、2、3...
        switchListener.currentPosition(checkedId);


    }

    public interface SwitchListener {
        void currentPosition(int position);
    }
}
