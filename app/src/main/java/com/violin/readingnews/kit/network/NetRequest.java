package com.violin.readingnews.kit.network;

import rx.Subscriber;

/**
 * Created by whl on 2016/10/20.
 */

public class NetRequest {
    private String action;
    private Object[] heders;
    private Object[] params;
    private byte[] eParams;
    private String host;
    private String url;//最终发送的完整url
    private Subscriber<HttpResponse> subscriber;

    public NetRequest host(String host) {
        this.host = host;
        return this;
    }

    public NetRequest action(String action) {
        this.action = action;
        return this;
    }

    public NetRequest headerKVs(Object... heders) {
        this.heders = heders;
        return this;
    }

    public NetRequest paramKVs(Object... params) {
        this.params = params;
        return this;
    }

    public NetRequest paramEncode(byte[] bytes) {
        this.eParams = bytes;
        return this;
    }

    public NetRequest listener(Subscriber<HttpResponse> subscriber) {
        this.subscriber = subscriber;
        return this;
    }

    public NetControl build() {
        return new NetControl(this);
    }

    public String getUrl() {
        url = host + action;
        return url;
    }

    public Object[] getHeders() {
        return heders;
    }

    public Object[] getParams() {
        return params;
    }

    public byte[] geteParams() {
        return eParams;
    }

    public Subscriber<HttpResponse> getSubscriber() {
        return subscriber;
    }
}
