package com.violin.readingnews.kit.network;

/**
 * Created by whl on 2016/10/20.
 */

public class NetControl {
    private NetRequest netRequest;

    NetControl(NetRequest netRequest) {
        this.netRequest = netRequest;
    }

    public void startGet() {
        RetrofitUtil.getInstance().getDataByGet(
                netRequest.getUrl(),
                netRequest.getHeders(),
                netRequest.getParams(),
                netRequest.getSubscriber());

    }

    public void startPost() {
        RetrofitUtil.getInstance().getDataByPost(
                netRequest.getUrl(),
                netRequest.getHeders(),
                netRequest.getParams(),
                netRequest.getSubscriber());

    }
    public void startPostEncode(){
        RetrofitUtil.getInstance().getDataByPostEncode(
                netRequest.getUrl(),
                netRequest.getHeders(),
                netRequest.geteParams(),
                netRequest.getSubscriber());
    }
}
