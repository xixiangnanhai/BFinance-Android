package com.lexiangkeji.bfinance.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * Created by 樊磊 on 2018/4/2.
 */

public class BFinanceApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Application mInstants;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstants = this;
        initSwiprefresh();
    }

    private void initSwiprefresh() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsHeader(getAppContext()).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
    }


    public static Application getAppContext() {
        return mInstants;
    }

}
