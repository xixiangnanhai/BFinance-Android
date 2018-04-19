package com.lexiangkeji.bfinance;

import android.annotation.SuppressLint;
import android.app.Application;

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
    }


    public static Application getAppContext() {
        return mInstants;
    }

}
