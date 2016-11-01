package com.violin.readingnews.kit.vpcontrol;

import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by whl on 2016/11/1.
 * <p>
 * ViewPager的控制类,用来监听每页滑动的生命周期
 */

public class ItemCyclerControl implements ViewPager.OnPageChangeListener, View.OnAttachStateChangeListener {
    private int currentPosition = -1;//当前显示的位置
    private int nextPosition = -1;//下一页
    private int prePosition = -1;//上一页

    private ViewPager viewPager;

    private List itemList;
    private boolean[] isFirstWillAppears;
    private boolean[] isFirstDidAppears;

    private int scrollState = ViewPager.SCROLL_STATE_IDLE;
    private int preScrollState = ViewPager.SCROLL_STATE_IDLE;
    private int viewPagerScrollState;

    /**
     * 关联ViewPager,需要在setAdapter之前调用
     *
     * @param viewPager
     */
    public void setupWithViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        viewPager.addOnAttachStateChangeListener(this);
    }

    public void setupWithItemList(List itemList) {
        this.itemList = itemList;
        isFirstWillAppears = new boolean[itemList.size()];
        isFirstDidAppears = new boolean[itemList.size()];
        for (int i = 0; i < itemList.size(); i++) {
            isFirstWillAppears[i] = true;
            isFirstDidAppears[i] = true;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        preScrollState = scrollState;
        if (positionOffset == 0) {
//            无下一页
            nextPosition = -1;
            //无偏移,在position位置停止状态
            scrollState = ViewPager.SCROLL_STATE_IDLE;
            if (currentPosition == position) {
                //记录的当前位置与当前位置相同
            } else {
                //记录的当前位置与当前位置不相同,位置有变化,通知监听者
                prePosition = currentPosition;
                currentPosition = position;
                notifyCycler();

            }

        } else {
            if (viewPagerScrollState == ViewPager.SCROLL_STATE_SETTLING) {
                //如果当前viewpager在自动移动，则忽略
                return;
            }
            //有偏移，在position位置的视图向左偏移量
            scrollState = ViewPager.SCROLL_STATE_DRAGGING;
            if (position == currentPosition) {
                //在当前位置向左滑动
                if (nextPosition != position + 1) {
                    //记录的下一位置与下一位置不相同，位置将有变化，通知监听者
                    nextPosition = position + 1;
                    notifyCycler();
                }
            } else {
                //在当前位置向右滑动
                if (nextPosition != position) {
                    //记录的下一位置与下一位置不相同，位置将有变化，通知监听者
                    nextPosition = position;
                    notifyCycler();
                }
            }
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        viewPagerScrollState = state;

    }

    @Override
    public void onViewAttachedToWindow(View v) {

    }

    //移除监听操作
    @Override
    public void onViewDetachedFromWindow(View v) {
        viewPager.removeOnAttachStateChangeListener(this);
        viewPager.removeOnPageChangeListener(ItemCyclerControl.this);

        for (Object item : itemList) {
            if (item instanceof ItemCyclerListener) {
                ((ItemCyclerListener) item).onDidDisAppear(true);
            }
        }

    }

    private void notifyCycler() {
        ItemCyclerListener currentView = getCyclerListener(currentPosition);
        ItemCyclerListener preView = getCyclerListener(prePosition);
        ItemCyclerListener nextView = getCyclerListener(nextPosition);
        if (currentView != null) {
            if (scrollState == ViewPager.SCROLL_STATE_IDLE) {
//                如果上一次状态是固定状态,非拖动状态,则先调用当前item的onWillAppear方法
                if (preScrollState == ViewPager.SCROLL_STATE_IDLE) {
                    currentView.onWillAppear(isFirstWillAppears[currentPosition]);
                    isFirstWillAppears[currentPosition] = false;
                }
                currentView.onDidAppear(isFirstWillAppears[currentPosition]);
                isFirstDidAppears[currentPosition] = false;
            } else {
                currentView.onWillDisAppear();
            }
        }
        if (preView != null) {
            if (scrollState == ViewPager.SCROLL_STATE_IDLE) {
                if (preScrollState == ViewPager.SCROLL_STATE_IDLE) {
//                    如果上一状态是固定状态,非拖动状态,则先调用上一个item的onWillDisAppear
                    preView.onWillDisAppear();
                }
                preView.onDidDisAppear(false);
            }
        }
        if (nextView != null) {
            if (scrollState != ViewPager.SCROLL_STATE_IDLE) {
                nextView.onWillAppear(isFirstWillAppears[nextPosition]);
                isFirstWillAppears[nextPosition] = false;
            }
        }

    }

    private ItemCyclerListener getCyclerListener(int position) {
        Object item = position >= 0 ? itemList.get(position) : null;
        if (item instanceof ItemCyclerListener) {
            return (ItemCyclerListener) item;
        }
        return null;
    }


}
