package com.violin.readingnews.kit.network;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by whl on 2016/10/20.
 */

public interface GetService {
    @GET("{action}")
    Observable<String> getData(@Path("action") String action, @HeaderMap Map<String, Object> hMap,
                                           @QueryMap Map<String, Object> pMap);
}
