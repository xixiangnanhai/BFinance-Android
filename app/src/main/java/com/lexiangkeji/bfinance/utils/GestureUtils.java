package com.lexiangkeji.bfinance.utils;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.lexiangkeji.bfinance.constant.Constants;

/**
 * Created by Eric.Gao on 2018/2/6.
 */

public class GestureUtils {

    public static boolean getIsSetGesture() {
        return SPUtils.getInstance(Constants.SP.SP_GESTURE).getBoolean(Constants.SP.IS_SET_GESTURE, false);
    }

    public static String getGesturePwd() {
        return SPUtils.getInstance(Constants.SP.SP_GESTURE).getString(Constants.SP.GESTURE_PWD, "");
    }

    public static void saveGesturePwd(String password) {
        if (TextUtils.isEmpty(password)) {
            return;
        }
        SPUtils.getInstance(Constants.SP.SP_GESTURE).put(Constants.SP.GESTURE_PWD, password);
        SPUtils.getInstance(Constants.SP.SP_GESTURE).put(Constants.SP.IS_SET_GESTURE, true);
    }

    public static void clearPwd() {
        SPUtils.getInstance(Constants.SP.SP_GESTURE).clear();
    }


}
