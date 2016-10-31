package com.violin.readingnews.kit.systemBar;

import android.app.Activity;
import android.graphics.Color;

/**
 * Created by violin on 16/3/19.
 */
public class SysBar {

    /**
     * 应用前景色
     *
     * @param activity
     */
    public static void applyTint(Activity activity) {
        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        // 使用颜色资源
        tintManager.setStatusBarTintColor(Color.rgb(55, 72, 80));
        tintManager.setStatusBarAlpha(0.6f);
    }

    public static void applyTintTransparent(Activity activity) {
        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarAlpha(0);
    }
}
