package com.violin.readingnews.kit.vpcontrol;

/**
 * Created by whl on 2016/11/1.
 */

public interface ItemCyclerListener {
    /**
     * 将要显示
     *
     * @param isFirst 是否第一次显示
     */
    void onWillAppear(boolean isFirst);

    /**
     * 已经完全显示
     *
     * @param isFirst 是否第一次
     */
    void onDidAppear(boolean isFirst);

    /**
     * 将要隐藏
     */
    void onWillDisAppear();

    /**
     * 已经完全隐藏
     */
    void onDidDisAppear(boolean isLast);

}
