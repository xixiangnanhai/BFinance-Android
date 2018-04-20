package com.lexiangkeji.bfinance.app_api.checker;

import android.databinding.Bindable;
import android.text.TextUtils;

public class ResetPassChecker extends ObservableChecker {

    public String phone;

    public String pass1;
    public String pass2;

    @Override
    public boolean isValidated() {
        return pass1.length() == 6
                && !isSeriesNum()
                && !isSameNum()
                && !phone.contains(pass1);
    }

    public boolean isSame(String s1, String s2) {
        return s1.equals(s2);
    }

    public boolean isSeriesNum() {
        char[] chars = pass1.toCharArray();
        if (chars[0] - chars[1] != -1 && chars[0] - chars[1] != 1) return false;
        for (int i = 0; i < 5; i++) {
            if ((chars[0] + 1 == chars[1] && chars[i] + 1 != chars[i + 1])
            || (chars[0] - 1 == chars[1] && chars[i] - 1 != chars[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public boolean isSameNum() {
        char[] chars = pass1.toCharArray();
        char start = chars[0];
        for (int i = 1; i < 6; i++) {
            if (chars[i] != start) return false;
        }
        return true;
    }

    @Bindable
    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
        notifyEnable();
    }

    @Bindable
    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
        notifyEnable();
    }

    @Override
    public boolean checkEnable() {
        return !TextUtils.isEmpty(pass1) && !TextUtils.isEmpty(pass2) && isSame(pass1, pass2);
    }
}
