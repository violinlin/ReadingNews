package com.violin.readingnews.kit.network.main;


import com.violin.readingnews.kit.network.NetRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by whl on 2016/10/20.
 */

public class MainRequest extends NetRequest {
    private final String HOST = "http://v.juhe.cn/";

    public MainRequest() {
        host(HOST);
    }


}
