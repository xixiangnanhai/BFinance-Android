package com.lexiangkeji.bfinance.app_api.api.converter;

import com.blankj.utilcode.util.LogUtils;
import com.lexiangkeji.bfinance.BuildConfig;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class GetReformer extends CarLoanRequestReformer {

    public GetReformer(Request preRequest, String key) {
        super(preRequest, key);
    }

    @Override
    protected Request createNewRequest() {
        Request.Builder builder = getReformedWithUrlRequestBuilder();
        Request reformRequest = builder.build();

        if ( BuildConfig.DEBUG) {
            LogUtils.d("SignInterceptor", reformRequest.url().toString());
        }
        return builder.build();
    }

    @Override
    protected HttpUrl createEncodeUrl() {
        HttpUrl.Builder builder = getPreRequest().url().newBuilder();
        return builder.build();
    }
}
