package com.violin.readingnews.news.main;

import com.violin.readingnews.BasePresenter;
import com.violin.readingnews.BaseView;

/**
 * Created by whl on 2016/10/31.
 */

public class MainContract {
    interface View extends BaseView<Presenter> {
        void updateNewsList();

    }

    interface Presenter extends BasePresenter<View> {
        void requestData(String action, String type);

    }
}
