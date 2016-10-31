package com.violin.readingnews;


/**
 * Created by whl on 2016/10/31.
 * <p>
 * mvp presenter基类
 */

public interface BasePresenter<T> {
    void setView(T BaseView);
}
