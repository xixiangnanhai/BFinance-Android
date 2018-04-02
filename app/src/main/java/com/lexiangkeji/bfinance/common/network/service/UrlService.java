package com.lexiangkeji.bfinance.common.network.service;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 樊磊 on 2018/4/2.
 */

public interface UrlService {

    @POST("demo/demo")
    Observable<Object> getDemo(@Body Object obj);

}
