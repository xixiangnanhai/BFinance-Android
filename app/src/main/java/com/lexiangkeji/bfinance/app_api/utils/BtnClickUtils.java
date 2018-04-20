package com.lexiangkeji.bfinance.app_api.utils;

/**
 * Created by Administrator on 2017/12/15.
 * <p>
 * 点击工具类
 */

public class BtnClickUtils {

    private static final int MIN_DELAY_TIME = 1000;  // 两次点击间隔不能少于1000ms
    private static long lastClickTime;

    public static boolean isFastClick() {
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
            flag = false;
        }
        lastClickTime = currentClickTime;
        return flag;
    }

}
