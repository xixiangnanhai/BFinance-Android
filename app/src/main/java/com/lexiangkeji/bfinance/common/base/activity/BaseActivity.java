package com.lexiangkeji.bfinance.common.base.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.lexiangkeji.bfinance.common.manager.ActivityManager;

/**
 * Created by 樊磊 on 2018/4/2.
 */

@SuppressLint("Registered")
public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.Instance().pushActivity(this);// 入栈
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.Instance().outStackActivity(this);// 出栈
    }
}
