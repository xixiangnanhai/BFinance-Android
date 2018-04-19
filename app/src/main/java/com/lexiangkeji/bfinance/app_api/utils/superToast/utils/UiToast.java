package com.lexiangkeji.bfinance.app_api.utils.superToast.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;

import com.lexiangkeji.bfinance.app_api.utils.superToast.Style;
import com.lexiangkeji.bfinance.app_api.utils.superToast.SuperToast;


/**
 * Created by newsolf on 2017/2/5.
 */

public class UiToast {

    private static SuperToast mSuperToast;

    public static void showShortToast(Context context, String text) {
        //如果内容为空,返回
        if (TextUtils.isEmpty(text)) {
            return;
        }
        //如果mSuperToast获取实例
        if (mSuperToast == null) {
            getSuperToast(context);
        }


        mSuperToast.setText(text);//内容
        mSuperToast.show();
    }

    private static void getSuperToast(Context context) {
        mSuperToast = new SuperToast(context);

        mSuperToast.setDuration(Style.DURATION_VERY_SHORT);//控制时长
        mSuperToast.setFrame(Style.FRAME_KITKAT);//控制样式
        mSuperToast.setTextSize(Style.TEXTSIZE_MEDIUM);//设置字体的大小
        mSuperToast.setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_RED));//背景颜色
        mSuperToast.setTextColor(Color.WHITE);//文字颜色
    }
}
