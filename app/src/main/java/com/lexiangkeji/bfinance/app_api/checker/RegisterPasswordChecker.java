package com.lexiangkeji.bfinance.app_api.checker;

import android.databinding.Bindable;
import android.text.TextUtils;

public class RegisterPasswordChecker extends ObservableChecker {

    public String phone;
    public String captcha;
    public String password;

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

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyEnable();
    }

    @Override
    public boolean checkEnable() {
        return !TextUtils.isEmpty(captcha) && captcha.length() == 4 &&
        !TextUtils.isEmpty(password) && password.length() >= 6;
    }



}
