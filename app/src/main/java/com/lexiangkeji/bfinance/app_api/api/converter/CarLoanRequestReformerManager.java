package com.lexiangkeji.bfinance.app_api.api.converter;

import okhttp3.Request;

public class CarLoanRequestReformerManager {

    private Request mPreRequest;
    private String md5key;
    private CarLoanRequestReformer mRequestReformer;

    public CarLoanRequestReformerManager(Request preRequest, String md5key) {
        mPreRequest = preRequest;
        this.md5key = md5key;
    }

    public Request createNewRequest() {
        switch (mPreRequest.method()) {
            case "GET":
                mRequestReformer = new GetReformer(mPreRequest, md5key);
                break;
            case "POST":
                mRequestReformer = new PostReformer(mPreRequest, md5key);
                break;
            default:
                return mPreRequest;
        }
        return mRequestReformer.createNewRequest();
    }

    public String getSign(){
         return mRequestReformer.getSign();
    }
}
