package com.lexiangkeji.bfinance.app_api.utils;

import android.text.TextUtils;

/**
 * Created by fanlei on 2017/12/4.
 */

public class NewOrOldUserUtils {
    /**
     * 判断是否为新手还是老手
     *
     * @param yearRateExtra 额外利率
     * @return 新手还是老手
     */
    public static boolean isOldUser(String yearRateExtra) {
        if (!TextUtils.isEmpty(yearRateExtra)
                && StringUtils.isDecimal(yearRateExtra)
                && Float.parseFloat(yearRateExtra) > 0) {
            return false;
        }
        return true;
    }

}
