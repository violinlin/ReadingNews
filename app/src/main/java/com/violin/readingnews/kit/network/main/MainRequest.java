package com.violin.readingnews.kit.network.main;


import com.violin.readingnews.kit.network.NetRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by whl on 2016/10/20.
 */

public class MainRequest extends NetRequest {

    public MainRequest() {
//        super.headerKVs("Content-Type", "application/json");//构架统一请求header
//        super.paramEncode(SecretUtil.aes_base64(buildJSONParams().toString(), "key"));
    }

    private JSONObject buildJSONParams() {
        JSONObject paramJson = new JSONObject();

        for (int i = 0; i < getParams().length; i++) {
            try {
                paramJson.put(getParams()[i].toString(), getParams()[i + 1]);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return paramJson;
    }

}
