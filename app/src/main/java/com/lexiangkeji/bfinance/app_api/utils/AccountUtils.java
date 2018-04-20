package com.lexiangkeji.bfinance.app_api.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.lexiangkeji.bfinance.constant.Constants;
import com.lexiangkeji.bfinance.mine.module.Account;


public class AccountUtils {

    private static final String KEY_ACCOUNT_JSON = "key_account_json";

    private static Account sCurrentAccount;
    private static SharedPreferences sSharedPreferences;
    private static Gson sGson;

    public static void init(Context context) {
        sSharedPreferences = context.getApplicationContext().getSharedPreferences("account", 0);
        sGson = GsonHelper.getDefault();
        readAccount();
    }

    public static Account getCurrentAccount() {
        checkInit();
//        LogUtils.e(sCurrentAccount);
        return sCurrentAccount;
    }

    public static String getUserId() {
        checkInit();
        if (sCurrentAccount != null) {
            return sCurrentAccount.userId;
        }
        return "";
    }

    public static boolean isLoggedIn() {
        checkInit();
        return sCurrentAccount != null && !TextUtils.isEmpty(sCurrentAccount.token);
    }


//    public static String getPhone() {
//        if (sCurrentAccount != null && !TextUtils.isEmpty(sCurrentAccount.phone)) {
//            return sCurrentAccount.phone.replaceAll("(\\d{3}).{4}(\\d{4})", "$1****$2");
//        }
//        return null;
//    }


    public static void login(Account account) {
        account.mUser = new Account.User();
        account.mUser.phone = account.mobile;
        LogUtils.e(account);
        if (account.userType == Constants.NewUserInvestedStatus.UNINVESTED) {
            setInvested(false);
        } else {
            setInvested(true);
        }
        saveAccount(account);

    }

    public static void update(Account account) {
        saveAccount(account);
    }

    public static void logout() {
        LogUtils.e("logout");
        sCurrentAccount.token = null;
        sCurrentAccount.userId = null;
        SPUtils.getInstance(Constants.SP.SP_CACHE_HOST).remove(Constants.SP.MINE_COUNT_INFO);
        SPUtils.getInstance(Constants.SP.SP_CACHE_HOST).remove(Constants.SP.MINE_ASSETS_INFO);
        SPUtils.getInstance(Constants.SP.SP_CACHE_HOST).remove(Constants.SP.MINE_ACCOUNT_INFO);
        SPUtils.getInstance(Constants.SP.SP_POP).remove(Constants.SP.POP_ID);// 情调活动
        SPUtils.getInstance(Constants.SP.SP_CACHE_HOST).remove(Constants.SP.CACHE_TOTAL_AMOUNT);
        SPUtils.getInstance(Constants.SP.SP_HIDE_MONEY).clear();//删除隐藏金额的状态

    }

    private static void readAccount() {
        String accountJson = sSharedPreferences.getString(KEY_ACCOUNT_JSON, null);
        if (accountJson != null) {
            sCurrentAccount = sGson.fromJson(accountJson, Account.class);
        } else {
            sCurrentAccount = new Account();
        }
    }

    private static void saveAccount(Account account) {
        checkInit();
        LogUtils.d(account);
        sCurrentAccount = account;
        LogUtils.d(sCurrentAccount);
        String accountJson = account != null ? sGson.toJson(account) : null;
        sSharedPreferences.edit()
                .putString(KEY_ACCOUNT_JSON, accountJson)
                .apply();
//        RxBus.getDefault().send(AccountUpdateEvent.INSTANCE);
    }

    public static boolean ensureLogin(Context context) {
        checkInit();
        if (!isLoggedIn()) {
            return false;
        }
        return true;
    }

    public static boolean isInvested() {
        return SPUtils.getInstance(Constants.SP.SP_ACCOUNT_STATUS).getBoolean(Constants.SP.IS_INVESTED, true);
    }

    public static void setInvested(boolean isInvested) {
        SPUtils.getInstance(Constants.SP.SP_ACCOUNT_STATUS).put(Constants.SP.IS_INVESTED, isInvested);
    }

    private static void checkInit() {
        if (sSharedPreferences == null) {
            throw new IllegalStateException("call init() first");
        }
    }


}
