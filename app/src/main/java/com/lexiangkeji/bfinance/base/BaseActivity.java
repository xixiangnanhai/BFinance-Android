package com.lexiangkeji.bfinance.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lexiangkeji.bfinance.manager.ActivityManager;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityManager.Instance().pushActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityManager.Instance().outStackActivity(this);
    }
}
