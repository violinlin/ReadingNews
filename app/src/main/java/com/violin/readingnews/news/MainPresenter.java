package com.violin.readingnews.news;


import android.util.Log;

import com.violin.readingnews.kit.network.CustomHttpResponse;
import com.violin.readingnews.kit.network.main.MainRequest;
import com.violin.readingnews.utils.Util;

import rx.Subscriber;

/**
 * Created by whl on 2016/10/31.
 * mvp
 * mvp中逻辑代码的实现类
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;

    @Override
    public void requestData(String action, String type) {
        new MainRequest()
                .action(action)
                .paramKVs("key", Util.KEY, "type", type)
                .listener(new Subscriber<CustomHttpResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("whl", e.getMessage());

                    }

                    @Override
                    public void onNext(CustomHttpResponse customHttpResponse) {
                        Log.d("whl", customHttpResponse.toString());
                        mView.updateNewsList();

                    }
                }).build().startPost();

    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
        mView.setPresenter(this);

    }
}
