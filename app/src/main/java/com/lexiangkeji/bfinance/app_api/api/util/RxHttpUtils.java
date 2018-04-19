package com.lexiangkeji.bfinance.app_api.api.util;


import com.lexiangkeji.bfinance.app_api.api.retry.RetryWhenNetworkException;
import com.lexiangkeji.bfinance.response.BitcoinBaseResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author:  fanlei
 * Time: 2017/9/12 15:50
 * <p>
 * 创建请求的对象,将一些公共操作放到一起
 */

public class RxHttpUtils {

    // 创建网络请求（不带token）
    public static <T extends BitcoinBaseResponse> Observable<T> createHttpRequest(final Observable<T> observable) {
        return observable
                .retryWhen(new RetryWhenNetworkException()) // 重试
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    // 创建合并网络请求 (merge)

    @SafeVarargs
    public static <T extends BitcoinBaseResponse> Observable<T> mergeHttpRequest(final Observable<T>... observables) {
        return Observable.merge(observables)
                .retryWhen(new RetryWhenNetworkException()) // 重试
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
