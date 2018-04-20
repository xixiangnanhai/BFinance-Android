package com.lexiangkeji.bfinance.app_api.utils;

import android.annotation.SuppressLint;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by 樊磊 on 2018/1/29.
 */

public class TimeUtils {

    /**
     * 判断当前时间  是否为周六、周天
     *
     * @param currentTimeMillis 当前时间的毫秒数
     * @return true false
     */
    private static boolean isWeekend(long currentTimeMillis) {
        Date current = new Date(currentTimeMillis);
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }


    // 判断是否可以进行拨打客服电话(时间为09.30 - 18.00)
    @SuppressLint("SimpleDateFormat")
    public static boolean isCanCallCustomerService(long currentTimeMillis) {
        if (isWeekend(currentTimeMillis)) {
            return false;
        } else {
            // 判断你是否在时间内
            Date currentData = new Date(currentTimeMillis);
            if (currentData.getHours() >= 9 && currentData.getHours() < 18) {
                if (currentData.getHours() == 9) {
                    if (currentData.getMinutes() >= 30) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
