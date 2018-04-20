package com.lexiangkeji.bfinance.app_api.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2018/2/26.
 */

public class HushengScrollView extends ScrollView {
    public HushengScrollView(Context context) {
        super(context);
    }

    public HushengScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HushengScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HushengScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (oldt < t && ((t - oldt) > 0)) {// 向上
            if (mListener != null) {
                mListener.onScrollTop(t);
            }
        } else if (oldt > t && (oldt - t) > 0) {// 向下
            if (mListener != null) {
                mListener.onScrollBottom(t);
            }
        }
    }

    private OnScrollListener mListener;

    public interface OnScrollListener {
        void onScrollTop(int t);

        void onScrollBottom(int t);
    }

    public void setOnScrollListener(OnScrollListener mListener) {
        this.mListener = mListener;
    }
}
