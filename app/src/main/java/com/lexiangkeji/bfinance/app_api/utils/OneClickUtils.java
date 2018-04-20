package com.lexiangkeji.bfinance.app_api.utils;

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2017/7/28 0028
 * 描述:
 * 历史:<br/>
 * ================================================
 */
public class OneClickUtils {
    private OneClickUtils() {
    }

    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 500;
    private static long lastClickTime;

    public static boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) <= MIN_CLICK_DELAY_TIME) {
//            Toaster.showToast("点击的太快了,请放松1秒");
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }
}
