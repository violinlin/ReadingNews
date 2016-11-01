package com.violin.readingnews.news.news;


import android.util.Log;

import com.google.gson.Gson;
import com.violin.readingnews.kit.network.HttpResponse;
import com.violin.readingnews.kit.network.main.MainRequest;
import com.violin.readingnews.utils.Util;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.LinkedList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by whl on 2016/11/1.
 */

public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.View mView;
    private List<NewsBean> beanList;

    @Override
    public void requestNewsData(String action, String type) {
        new MainRequest()
                .action(action)
                .paramKVs("key", Util.KEY, "type", type)
                .listener(new Subscriber<HttpResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("whl", e.getMessage());

                    }

                    @Override
                    public void onNext(HttpResponse httpResponse) {
                        int code = httpResponse.getError_code();
                        if (code == 0) {


                            beanList = new LinkedList<NewsBean>();
                            NewsBean bean;
                            Gson gson;
                            try {
                                JSONArray array = httpResponse.getResult().getJSONArray("data");
                                for (int i = 0; i < array.length(); i++) {
                                    gson = new Gson();
                                    bean = gson.fromJson(array.getString(i), NewsBean.class);
                                    beanList.add(bean);
                                }

                                mView.upDateNewsList(beanList);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            String mes = httpResponse.getReason();
                        }

                    }
                }).build().startPost();
    }


    @Override
    public void setView(NewsContract.View view) {
        this.mView = view;
    }
}
