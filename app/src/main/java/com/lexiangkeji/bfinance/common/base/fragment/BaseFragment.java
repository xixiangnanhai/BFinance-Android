package com.lexiangkeji.bfinance.common.base.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lexiangkeji.bfinance.view.weight.BaseView;

/**
 * Created by 樊磊 on 2018/4/2.
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    // ----------------- 懒加载所用到的变量 ------------------
    protected boolean isVisible;
    private boolean isPrepared;
    private boolean isFirst = true;

    protected T mBinding;


    private int mlayoutId;
    private BaseView baseView;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            isVisible = true;
            lazy();
        } else {
            isVisible = false;
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mlayoutId = setContentView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        baseView = new BaseView(container.getContext());
        mBinding = DataBindingUtil.inflate(inflater, mlayoutId, container, false);
        baseView.setContentView(mBinding.getRoot());
        return baseView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        lazy();
    }

    // 懒加载的方法
    private void lazy() {
        if (!isPrepared || !isVisible || !isFirst) {
            return;
        }
        lazyLoadData(); // 该方法 只会被调用一次
        isFirst = false;
    }

    // 懒加载的方法
    protected void lazyLoadData() {
        /* 懒加载方法 */
    }

    // 设置布局ID
    protected abstract int setContentView();

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
}
