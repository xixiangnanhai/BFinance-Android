package com.lexiangkeji.bfinance.view.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.lexiangkeji.bfinance.R;

/**
 * Created by 樊磊 on 2018/4/4.
 * <p>
 * baseView
 * 1、标题栏 、contentView容器、无网络界同一层级
 * 2、
 */

public class BaseView extends LinearLayout {

    private View titleBar;// 标题栏
    private FrameLayout content_container; // 内容容器

    private View netWorkErrorView;         // 无网络界面

    private View noDataView;               // 无数据界面
    private View contentView;              // 内容view

    private boolean isNeedTitleBar = false;// 是否需要标题栏

    public BaseView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @SuppressLint("NewApi")
    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    private void init(Context context) {
        setOrientation(VERTICAL);
    }

    // 展示无数据界面
    public void showNoDataView() {

        removeAllViews();

        if (titleBar == null && isNeedTitleBar) {
            titleBar = LayoutInflater.from(getContext()).inflate(R.layout.base_view_title_bar_layout, null);
            titleBar.setTag("titleBar");
        }

        if (content_container == null) {
            content_container = new FrameLayout(getContext());
            content_container.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));
            content_container.addView(contentView);
            content_container.setTag("content_container");
        }

        if (noDataView == null) {
            noDataView = LayoutInflater.from(getContext()).inflate(R.layout.base_view_no_data_layout, content_container, false);
            noDataView.setTag("noDataView");
        }

        if (findViewWithTag("titleBar") == null) {
            addView(titleBar);
        }

        if (findViewWithTag("content_container") == null) {
            addView(content_container);
        }

        if (content_container.findViewWithTag("noDataView") == null) {
            content_container.addView(noDataView);
        }

    }

    // 展示无网络界面
    public void showNoNetWorkView() {

        removeAllViews();

        if (netWorkErrorView == null) {
            netWorkErrorView = LayoutInflater.from(getContext()).inflate(R.layout.base_view_no_network_layout, this, false);
            netWorkErrorView.setTag("netWorkErrorView");
        }

        if (findViewWithTag("netWorkErrorView") == null) {
            addView(netWorkErrorView);
        }

    }

    // 展示主界面
    public void showContentView() {

        removeView(netWorkErrorView);

        if (titleBar == null && isNeedTitleBar) {
            titleBar = LayoutInflater.from(getContext()).inflate(R.layout.base_view_title_bar_layout, null);
            titleBar.setTag("titleBar");
        }

        if (content_container == null) {
            content_container = new FrameLayout(getContext());
            content_container.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));
            content_container.addView(contentView);
            content_container.setTag("content_container");
        }

        if (findViewWithTag("titleBar") == null) {
            addView(titleBar);
        }

        if (findViewWithTag("content_container") == null) {
            addView(content_container);
        }

    }

    // 添加主界面视图
    public void setContentView(View contentView) {
        this.contentView = contentView;
    }

    // 设置是否须要标题栏
    public void setNeedTitleBar(boolean isNeedTitleBar) {
        this.isNeedTitleBar = isNeedTitleBar;
    }
}
