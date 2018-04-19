package com.lexiangkeji.bfinance.app_api.utils;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2017/7/19 0019
 * 描述:
 * 历史:<br/>
 * ================================================
 */
public class CashUtils {
    private CashUtils() {
    }

    public static double stringToDouble(@NonNull String str) {
        try {
            return DecimalFormat.getInstance().parse(str).doubleValue();
        } catch (ParseException e) {
            return 0.00;
        }
    }

    public static String format(double d) {
        String result = "0.00";
        DecimalFormat df = new DecimalFormat("#,##0.00");
        result = d <= 0 ? result : df.format(d);
        return result;
    }

    public static String format(int d) {
        String result = "0";
        DecimalFormat df = new DecimalFormat("#,##0");
        result = d <= 0 ? result : df.format(d);
        return result;
    }


    public static String formatToTenThousandUnit(long money) {
        int tenThousand = 10000;
        if (money > tenThousand && money % tenThousand == 0 && money / tenThousand >= 1) {
            int moneyInUnit = (int) (money / tenThousand);
            return moneyInUnit + "万";
        } else {
            return money + "";
        }
    }

    public static String formatToTenThousandUnit(double money) {
        int tenThousand = 10000;
        if (money > tenThousand && money % tenThousand == 0 && money / tenThousand >= 1) {
            int moneyInUnit = (int) (money / tenThousand);
            return moneyInUnit + "万";
        } else {
            return money + "";
        }
    }
}
