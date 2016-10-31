package com.violin.readingnews.utils;

import android.content.Context;

import java.lang.reflect.Field;

/**
 * Created by whl on 2016/10/31.
 */

public class Util {
    public static final String KEY="2c03a39f3b9d45f6a6a92e6dc7013a3e";
    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getSysStatusHeight(Context context) {
        int sysStautsHeight = 0;
        if (sysStautsHeight == 0) {
            Class<?> c = null;
            Object obj = null;
            Field field = null;
            int x = 0, sbar = 0;
            try {
                c = Class.forName("com.android.internal.R$dimen");
                obj = c.newInstance();
                field = c.getField("status_bar_height");
                x = Integer.parseInt(field.get(obj).toString());
                sysStautsHeight = context.getResources().getDimensionPixelSize(x);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return sysStautsHeight;
    }

    /**
     * dp转px
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context, int dp) {
        float desity = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * desity) + 0.5f);
    }

    /**
     * px转dp
     *
     * @param context
     * @param px
     * @return
     */
    public static int px2dp(Context context, int px) {
        float desity = context.getResources().getDisplayMetrics().density;
        return (int) ((px / desity) + 0.5f);
    }
}
