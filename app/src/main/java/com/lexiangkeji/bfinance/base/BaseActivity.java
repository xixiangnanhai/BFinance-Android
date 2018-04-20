package com.lexiangkeji.bfinance.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.manager.ActivityManager;

public class BaseActivity extends AppCompatActivity {

    private HSToolbar mToolbar;
    private View mContentView;
    @ColorInt
    private int mStatusColor = -1;
    public enum ToolbarStyle {
        WHITE,
        GROWN,
        NONE
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.Instance().pushActivity(this);
//        StatusUtils.setStatusBarColor(R.color.background_color);

    }

    @Override
    public void setContentView(View view) {
        super.setContentView(R.layout.activity_base);
        FrameLayout container = findViewById(R.id.base_view_container);
        container.addView(view);
        mContentView = view;
        mToolbar = findViewById(R.id.base_toolbar);
        initToolbar();
    }
    /**
     * 初始化toolbar
     */
    private void initToolbar() {
        if (mToolbar != null) {
            ToolbarStyle mToolbarStyle = onInitToolbarStyle(mToolbar);
            int textColor = 0;
            if (mToolbarStyle == ToolbarStyle.WHITE) {
                mToolbar.setLeftImageResource(R.mipmap.icon_back);
                mToolbar.setBackgroundColor(getResources().getColor(R.color.white));
                textColor = getResources().getColor(R.color.black);
                mToolbar.setTitleStyle(R.style.ToolbarTextInWhite);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    mStatusColor = getColor(R.color.color_EEEEEE);
                } else {
                    mStatusColor = getResources().getColor(R.color.color_666666);
                }
            } else if (mToolbarStyle == ToolbarStyle.GROWN) {
                mToolbar.setLeftImageResource(R.mipmap.icon_back_white);
                mToolbar.setBackgroundColor(getResources().getColor(R.color.color_fcdc59));
                textColor = getResources().getColor(R.color.white);
                mToolbar.setTitleStyle(R.style.ToolbarTextInYellow);
                mStatusColor = getResources().getColor(R.color.background_color);
            } else {
                mToolbar.setVisibility(View.GONE);
                return;
            }
            mToolbar.setTitleSize(18);
            mToolbar.setLeftCloseVisible(false);
            mToolbar.setActionTextColor(textColor);
            mToolbar.setLeftImageClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                    hideSoftInputFromWindow(v);
                }
            });
            mToolbar.setLeftCloseClickListener(v -> {
                hideSoftInputFromWindow(v);
                finish();
            });
            if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //因为所有的界面并没有全部替换为新的基类, 所以19以下暂时封锁使用
                //替换完成后, 即可在这里放开限制
                setImmersive(true);
            }
        }
    }
    /**
     * 可调用并调整toolBar, 初始化界面时回调
     *
     * @return true:表示定制完成, false 表示使用默认
     */
    protected ToolbarStyle onInitToolbarStyle(HSToolbar toolBar) {
        return ToolbarStyle.NONE;
    }

    /**
     * 原生setContentView. 不兼容Data-Binding
     */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base);
        FrameLayout container = findViewById(R.id.base_view_container);
        mContentView = getLayoutInflater().inflate(layoutResID, container, true);
        mToolbar = findViewById(R.id.base_toolbar);
        initToolbar();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.Instance().outStackActivity(this);
    }
    /**
     * 隐藏软键盘
     */
    protected boolean hideSoftInputFromWindow(View view) {
        if (null == view) {
            return false;
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && imm.isActive()) {
            return imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return false;
    }

}
