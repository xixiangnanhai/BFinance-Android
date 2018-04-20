package com.lexiangkeji.bfinance.app_api.checker;

import android.databinding.Bindable;
import android.text.TextUtils;

public class PhoneCaptchaChecker extends ObservableChecker {

    private String phoenRegex = "1\\d{10}";

    public String phone;
    public String captcha;

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyEnable();
    }

    @Bindable
    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
        notifyEnable();
    }

    @Override
    public boolean isValidated() {
        if (TextUtils.isEmpty(phone)) {
            return false;
        }
        if (!phone.matches(phoenRegex)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkEnable() {
        return !TextUtils.isEmpty(phone)
                && !TextUtils.isEmpty(captcha)
                && captcha.length() == 4;
    }

}
