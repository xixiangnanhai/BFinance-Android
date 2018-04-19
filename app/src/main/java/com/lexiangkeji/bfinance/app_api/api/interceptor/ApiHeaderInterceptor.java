package com.lexiangkeji.bfinance.app_api.api.interceptor;

import android.text.TextUtils;

import com.laputapp.Laputapp;
import com.lexiangkeji.bfinance.BFinanceApplication;
import com.lexiangkeji.bfinance.app_api.api.converter.CarLoanRequestReformerManager;
import com.lexiangkeji.bfinance.constant.Constant;
import com.lexiangkeji.bfinance.mine.module.Account;
import com.lexiangkeji.bfinance.utils.AccountUtils;
import com.mcxiaoke.packer.helper.PackerNg;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiHeaderInterceptor implements Interceptor {

    private static final String sVersion = Laputapp.getAppInfo().version;
    private static final String sVersionCode = Laputapp.getAppInfo().versionCode;
    private static final String sDeviceId = Laputapp.getAppInfo().deviceId;
    private static final String mMarket = PackerNg.getMarket(BFinanceApplication.getAppContext());
    private static final String sChannelId = TextUtils.isEmpty(mMarket) ? "ImHuaSheng" : mMarket;
    private static final String mPackageName = Laputapp.getAppContext().getPackageName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        CarLoanRequestReformerManager reformerManager = new CarLoanRequestReformerManager(
                originalRequest, Constant.API_KEY);
        Request newRequest = reformerManager.createNewRequest();
        Request.Builder requestBuilder = newRequest.newBuilder()
                .addHeader("build", sVersionCode)
                .addHeader("appVersion", sVersion)
                .addHeader("platform", "android")
                .addHeader("device_id", sDeviceId)
                .addHeader("channel_id", sChannelId)
                .addHeader("timestamp", String.valueOf(System.currentTimeMillis() / 1000))
                .addHeader("packageName", mPackageName);


        Account account = AccountUtils.getCurrentAccount();
        String token = "";
        String userId = "";
        if (account != null && account.token != null && account.userId != null) {
            token = account.token;
            userId = account.userId;
        }

        requestBuilder
                .addHeader("token", token);
        requestBuilder
                .addHeader("userId", userId);

        return chain.proceed(requestBuilder.build());
    }
}
