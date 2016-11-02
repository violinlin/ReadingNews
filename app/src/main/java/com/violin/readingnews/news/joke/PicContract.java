package com.violin.readingnews.news.joke;

import com.violin.readingnews.news.BasePresenter;
import com.violin.readingnews.news.BaseView;

import java.util.List;

/**
 * Created by whl on 2016/11/1.
 */

public class PicContract {
    interface View extends BaseView {
        void updateJokeList(List<PicBean> beanList);
    }


    interface Presenter extends BasePresenter<PicContract.View> {
        void requestData(int page, int count);
    }
}
