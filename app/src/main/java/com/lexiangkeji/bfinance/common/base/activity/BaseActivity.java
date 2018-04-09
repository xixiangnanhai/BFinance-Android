package com.lexiangkeji.bfinance.common.base.activity;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lexiangkeji.bfinance.common.manager.ActivityManager;
import com.lexiangkeji.bfinance.common.utils.StatusUtils;
import com.lexiangkeji.bfinance.view.weight.BaseView;

/**
 * Created by 樊磊 on 2018/4/2.
 */

@SuppressLint("Registered")
public abstract class BaseActivity<T extends ViewDataBinding> extends FragmentActivity {

    protected T mBinding;

    private BaseView baseView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.Instance().pushActivity(this);// 入栈
        StatusUtils.setFullToStatusBar(this);// 沉浸式
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.Instance().outStackActivity(this);// 出栈
    }


    @Override
    public void setContentView(int layoutResID) {
        baseView = new BaseView(this);
        baseView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutResID, null, false);
        baseView.setContentView(mBinding.getRoot());
        setContentView(baseView);
    }

    // 展示主界面
    protected void showContentView() {
        baseView.showContentView();
    }

    // 展示无数据界面
    protected void showNoNetWorkView() {
        baseView.showNoNetWorkView();
    }

    // 展示无数据界面
    protected void showNoDataView() {
        baseView.showNoDataView();
    }

    // 是否需要标题栏
    protected abstract boolean needTitleBar();

}
