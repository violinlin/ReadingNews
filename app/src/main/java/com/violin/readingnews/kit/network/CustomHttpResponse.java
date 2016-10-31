package com.violin.readingnews.kit.network;

/**
 * Created by whl on 2016/10/20.
 * 该类是对返回报文的转换实体类,工具服务器的返回格式和内容来定义。
 */

public class CustomHttpResponse {
    private String reason;
    private Object result;
    private int error_code;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("reason").append(reason)
                .append("result").append(result)
                .append("error_code").append(error_code)
                .append("data").append(data);
        return sb.toString();
    }
}
