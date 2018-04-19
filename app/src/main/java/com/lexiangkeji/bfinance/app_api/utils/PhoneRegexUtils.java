package com.lexiangkeji.bfinance.app_api.utils;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2017/8/5 0005
 * 描述:
 * 历史:<br/>
 * ================================================
 */
public class PhoneRegexUtils {

    private static String regExp = "^((13[0-9])|(15[0-9])|(16[1-9,4-7])|(18[0-9])|(19[0-9])|(17[0-8])|(14[5-9])|(11[0-9]))\\d{8}$";  //11开头的为测试数据

    public static boolean isMobileSimple(CharSequence input) {
        return isMatch(regExp, input);
    }


    /**
     * 判断是否匹配正则
     *
     * @param regex 正则表达式
     * @param input 要匹配的字符串
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMatch(String regex, CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

    /**
     * 格式化手机号
     */
    public static String formatPhoneNumber(String phone) {
        if (!TextUtils.isEmpty(phone) && phone.length() >= 11) {
            return phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
        } else {
            return "";
        }
    }
}
