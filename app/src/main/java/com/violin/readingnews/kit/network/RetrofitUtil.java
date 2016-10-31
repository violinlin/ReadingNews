package com.violin.readingnews.kit.network;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by whl on 2016/10/20.
 * 网络请求基础类
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;
    private static final String HOST = "http://v.juhe.cn/toutiao/";
    private Retrofit retrofit;
    private static final int TIME_OUT = 5;
    private PostService postService;//post服务
    private GetService getService;

    private RetrofitUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())//返回报文的转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//使用Rxjava的适配器
                .baseUrl(HOST)
                .build();

        postService = retrofit.create(PostService.class);
        getService = retrofit.create(GetService.class);
    }

    public synchronized static RetrofitUtil getInstance() {
        if (retrofitUtil == null) {
            retrofitUtil = new RetrofitUtil();
        }
        return retrofitUtil;
    }

    public void getDataByPost(String action, Object headers[], Object params[], Subscriber<CustomHttpResponse> subscriber) {
        postService.getData(action, buildMap(headers), buildMap(params))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);


    }

    public void getDataByPostEncode(String action, Object headers[], byte[] bytes, Subscriber<CustomHttpResponse> subscriber) {
        postService.getDataEncode(action, buildMap(headers), buildParams(bytes))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getDataByGet(String action, Object heasers[], Object params[], Subscriber<CustomHttpResponse> subscriber) {
        getService.getData(action, buildMap(heasers), buildMap(params))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    //对加密后的请求参数的转换
    private RequestBody buildParams(byte[] bytes) {
        RequestBody requestBody = RequestBody.create(MediaType.parse(""), bytes);
        return requestBody;

    }

    //键值对的拼接
    private Map<String, Object> buildMap(Object params[]) {
        Map<String, Object> map = new HashMap<>();
        if (params != null && params.length % 2 == 0) {
            for (int i = 0; i < params.length - 1; i += 2) {
                map.put((String) params[i], params[i + 1]);
            }
        } else {
            throw new RuntimeException("参数错误!");
        }
        return map;
    }


}