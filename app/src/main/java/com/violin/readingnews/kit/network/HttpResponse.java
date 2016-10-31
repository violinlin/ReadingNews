package com.violin.readingnews.kit.network;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by whl on 2016/10/31.
 */

public class HttpResponse {
    private String reason;
    private JSONObject result;
    private int error_code;

    public HttpResponse parseJSON(String str){
        try {
            JSONObject jsonObject=new JSONObject(str);
            reason=jsonObject.getString("reason");
            result =jsonObject.getJSONObject("result");
            error_code=jsonObject.getInt("error_code");


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return this;

    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
