package com.violin.readingnews.news.joke;

import android.util.Log;

import com.google.gson.Gson;
import com.violin.readingnews.kit.network.HttpResponse;
import com.violin.readingnews.kit.network.main.MainRequest;
import com.violin.readingnews.utils.Util;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by whl on 2016/11/1.
 */

public class PicPresenter implements PicContract.Presenter {
    private PicContract.View mView;
    private List<PicBean> picBeanList;

    @Override
    public void requestData(int page, int count) {
        new MainRequest()
                .host("http://japi.juhe.cn/")
                .action("joke/img/text.from")
                .paramKVs("page", page, "pagesize", count, "key", Util.KEY_JOKE)
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

                        if (httpResponse.getError_code() == 0) {
                            try {
                                picBeanList = new ArrayList<PicBean>();
                                JSONArray array = httpResponse.getResult().getJSONArray("data");
                                Gson gson;
                                PicBean picBean;
                                for (int i = 0; i < array.length(); i++) {
                                    gson = new Gson();
                                    picBean = gson.fromJson(array.getString(i), PicBean.class);
                                    picBeanList.add(picBean);
                                }
                                mView.updateJokeList(picBeanList);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            String msg = httpResponse.getReason();
                        }


                    }
                }).build().startGet();

    }

    @Override
    public void setView(PicContract.View view) {
        this.mView = view;
    }
}
