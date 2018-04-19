package com.lexiangkeji.bfinance.app_api.api;

import android.text.TextUtils;
import android.view.View;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.app_api.api.dialog.HSWindowDialog;
import com.lexiangkeji.bfinance.app_api.pop.PopMgr;
import com.lexiangkeji.bfinance.app_api.utils.Toaster;
import com.lexiangkeji.bfinance.base.IBaseView;
import com.lexiangkeji.bfinance.utils.AccountUtils;
import com.tencent.bugly.beta.Beta;

/**
 * 数据返回的统一处理封装器
 * todo 目前职责不纯粹. 应将业务层拆出来
 */
public class ResponseObservable {

    private static final String TAG = ResponseObservable.class.getSimpleName();


    private static <T> void errorSwitch(IBaseView view, int code, String message) {
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

//    public static <T> Observable<HuaShengBaseResponse<T>> unwrap(IBaseView view, Observable<HuaShengBaseResponse<T>> observable) {
//        return observable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnError(throwable -> {
//                    Log.d(TAG, throwable.getMessage());
//                    Log.d(TAG, throwable.toString());
//
//                })
//                .doOnError(throwable -> {
//                    if (throwable != null) {
//                        Log.e("ResponseObservable", "" + throwable.getMessage());
//                    }
//                })
//                .onErrorResumeNext(Observable.empty())
//                .filter(tResponse -> {
//                    if (!tResponse.isSuccessed()) {
//                        errorSwitch(view, tResponse.getCode(), tResponse.getMessage());
//                    }
//                    if (BuildConfig.DEBUG) {
//                        Log.d(TAG, String.format("code: %s, msg: %s", tResponse.getCode(), tResponse.getMessage()));
//                    }
//                    return tResponse.isSuccessed();
//                })
//                .doOnSubscribe(view::showProgress)
//                .doOnTerminate(view::hideProgress);
//    }


}
