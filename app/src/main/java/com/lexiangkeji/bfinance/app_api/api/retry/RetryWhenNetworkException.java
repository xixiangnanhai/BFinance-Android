package com.lexiangkeji.bfinance.app_api.api.retry;


import com.blankj.utilcode.util.LogUtils;
import com.lexiangkeji.bfinance.app_api.utils.NetworkUtils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observable;
import rx.exceptions.CompositeException;
import rx.functions.Func1;
import rx.functions.Func2;


/**
 * Create by fanlei 09/11/2017
 * 超时重试机制
 */
public class RetryWhenNetworkException implements Func1<Observable<? extends Throwable>, Observable<?>> {

    private int count = 0;    //  重试次数
    private long delay = 2000;//  重试时间间隔

    public RetryWhenNetworkException() {

    }

    public RetryWhenNetworkException(int count) {
        this.count = count;
    }

    public RetryWhenNetworkException(int count, long delay) {
        this.count = count;
        this.delay = delay;
    }

    @Override
    public Observable<?> call(Observable<? extends Throwable> observable) {
        return observable
                .zipWith(Observable.range(1, count + 1), new Func2<Throwable, Integer, Wrapper>() {
                    @Override
                    public Wrapper call(Throwable throwable, Integer integer) {
                        return new Wrapper(throwable, integer);
                    }
                }).flatMap(new Func1<Wrapper, Observable<?>>() {
                    @Override
                    public Observable<?> call(Wrapper wrapper) {
                        if (!NetworkUtils.isNetworkAvailable()) {
                            return Observable.empty();
                        }
                        if ((wrapper.throwable instanceof ConnectException
                                || wrapper.throwable instanceof SocketTimeoutException
                                || wrapper.throwable instanceof TimeoutException
                                || wrapper.throwable instanceof CompositeException
                                || wrapper.throwable instanceof IOException)
                                && wrapper.index < count + 1) {
                            LogUtils.d("RetryWhenNetworkExcepti", "出现异常，开始重试~~~~");
                            return Observable.timer(delay + (wrapper.index - 1) * delay, TimeUnit.MILLISECONDS);
                        } else if ((wrapper.throwable instanceof ConnectException
                                || wrapper.throwable instanceof SocketTimeoutException
                                || wrapper.throwable instanceof TimeoutException
                                || wrapper.throwable instanceof CompositeException
                                || wrapper.throwable instanceof IOException)
                                && wrapper.index == count + 1) {
                            return Observable.error(wrapper.throwable);
                        }
                        return Observable.error(wrapper.throwable);
                    }
                });
    }

    private class Wrapper {
        private int index;
        private Throwable throwable;

        public Wrapper(Throwable throwable, int index) {
            this.index = index;
            this.throwable = throwable;
        }
    }
}
