package com.lexiangkeji.bfinance.app_api.utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class RxBus {

    private static volatile RxBus sDefaultInstance;

    private RxBus() {
    }

    public static RxBus getDefault() {
        if (sDefaultInstance == null) {
            synchronized (RxBus.class) {
                if (sDefaultInstance == null) {
                    sDefaultInstance = new RxBus();
                }
            }
        }
        return sDefaultInstance;
    }

    private final Subject<Object, Object> mBus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        mBus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return mBus;
    }


}