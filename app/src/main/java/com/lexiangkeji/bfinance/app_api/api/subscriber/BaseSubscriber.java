package com.lexiangkeji.bfinance.app_api.api.subscriber;


import android.text.TextUtils;
import android.view.View;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.JsonSyntaxException;
import com.lexiangkeji.bfinance.BFinanceApplication;
import com.lexiangkeji.bfinance.BuildConfig;
import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.app_api.api.dialog.HSWindowDialog;
import com.lexiangkeji.bfinance.app_api.pop.PopMgr;
import com.lexiangkeji.bfinance.app_api.utils.NetworkUtils;
import com.lexiangkeji.bfinance.app_api.utils.Toaster;
import com.lexiangkeji.bfinance.base.IBaseView;
import com.lexiangkeji.bfinance.response.BitcoinBaseResponse;
import com.lexiangkeji.bfinance.utils.AccountUtils;
import com.tencent.bugly.beta.Beta;

import java.net.SocketTimeoutException;

import rx.Subscriber;

public abstract class BaseSubscriber<T extends BitcoinBaseResponse> extends Subscriber<T> {

    private IBaseView iBaseView;

    private boolean isShowLoading;

    public BaseSubscriber(IBaseView iBaseView) {
        this.iBaseView = iBaseView;

        //default true
        isShowLoading = true;
    }

    public BaseSubscriber(IBaseView iBaseView, boolean isShowLoading) {
        this.iBaseView = iBaseView;
        this.isShowLoading = isShowLoading;
    }

    public abstract void onResult(T t);

    @Override
    public void onStart() {
        super.onStart();

        if (!NetworkUtils.isNetworkAvailable()) {

            onError(new HuaShengException(iBaseView, -40001, "网络不可用，请检查手机网络"));

            // **一定要主动调用下面这一句**
            onCompleted();

            return;
        }
        if (isShowLoading) {
            // 显示进度条
            iBaseView.showProgress();
        }

    }

    @Override
    public void onCompleted() {
        if (isShowLoading) {
            //关闭等待进度条
            iBaseView.hideProgress();
        }
    }


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (isShowLoading) {
            //关闭等待进度条
            iBaseView.hideProgress();
        }
        if (e instanceof SocketTimeoutException) {
            new PersistentCookieJar(new SetCookieCache(),
                    new SharedPrefsCookiePersistor(BFinanceApplication.getAppContext())).clearSession();
        }

        // 由于当时这个借口到时没有统一处理，故这里捕获一下json解析异常
        if (e instanceof JsonSyntaxException) {
            if ( BuildConfig.DEBUG) {
                Toaster.showToast("解析异常");
            } else {
                Toaster.showToast("网络开小差了，请稍后重试");
            }
            return;
        }

        if (!(e instanceof HuaShengException)) {
            Toaster.showToast("网络开小差了，请稍后重试");
        }
    }

    @Override
    public void onNext(T t) {
        if (!t.isSuccessed()) {
            onError(new HuaShengException(iBaseView, t.getCode(), t.getMessage()));
        } else {
            onResult(t);
        }
    }


    public static class HuaShengException extends Throwable {

        private int code;

        public int getCode() {
            return code;
        }

        public HuaShengException(IBaseView iBaseView, int code, String message) {
            super(message);
            this.code = code;
            errorSwitch(iBaseView, code, message);
        }

        HuaShengException(String message) {
            super(message);
        }

        public static void errorSwitch(IBaseView view, int code, String message) {
            switch (code) {
                case 400:
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    new HSWindowDialog(view.getContext())
                            .title("提示")
                            .message(message)
                            .dialogType(HSWindowDialog.DialogType.SINGLE.value)
                            .show();
                    break;
                case -10201:
                case -10202:
                case -10205:
                    AccountUtils.logout();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    PopMgr.getInstance().showTokenErrorDialog(message);
                    break;
                case -20001:
                    new HSWindowDialog(view.getContext())
                            .title("提示")
                            .message(message)
                            .dialogType(HSWindowDialog.DialogType.SINGLE.value)
                            .confirmStr(view.getContext().getString(R.string.common_known))
                            .show();
                    break;
                case -20002:
                    new HSWindowDialog(view.getContext())
                            .title("提示")
                            .message(message)
                            .dialogType(HSWindowDialog.DialogType.DEFAULT.value)
                            .listener(new HSWindowDialog.OnDialogClickListener() {
                                @Override
                                public void onConfirm(View v, int actionType, Object extra) {
                                    Beta.checkUpgrade();
                                }

                                @Override
                                public void onCancel(View v, int actionType, Object extra) {
                                }
                            })
                            .show();
                    break;
                default:
                    Toaster.showToast(message);
                    break;
            }
        }


    }
}