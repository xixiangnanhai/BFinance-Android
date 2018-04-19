package com.lexiangkeji.bfinance.app_api.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class AdaptiveGridView extends GridView {

    public AdaptiveGridView(Context context) {
        this(context, null);
    }

    public AdaptiveGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdaptiveGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
