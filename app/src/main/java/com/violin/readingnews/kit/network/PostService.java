package com.violin.readingnews.kit.network;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by whl on 2016/10/20.
 */

public interface PostService {
    @FormUrlEncoded
    @POST()
    Observable<String> getData(@Url String url, @HeaderMap Map<String, Object> headmap, @FieldMap Map<String, Object> pMap);

    @POST()
    Observable<String> getDataEncode(@Url String url, @HeaderMap Map<String, Object> headmap, @Body RequestBody requestBody);
}

