package com.violin.readingnews.news.news;

import com.violin.readingnews.news.BasePresenter;
import com.violin.readingnews.news.BaseView;

import java.util.List;

/**
 * Created by whl on 2016/11/1.
 */

public class NewsContract {
    interface View extends BaseView {
        void upDateNewsList(List<NewsBean> beens);
    }

    interface Presenter extends BasePresenter<NewsContract.View> {
        void requestNewsData();
    }
}
