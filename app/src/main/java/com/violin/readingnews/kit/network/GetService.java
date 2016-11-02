package com.violin.readingnews.kit.network;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by whl on 2016/10/20.
 */

public interface GetService {
    @GET()
    Observable<String> getData(@Url String url, @HeaderMap Map<String, Object> hMap,
                               @QueryMap Map<String, Object> pMap);
}
