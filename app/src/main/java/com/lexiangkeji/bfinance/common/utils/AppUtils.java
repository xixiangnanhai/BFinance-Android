package com.lexiangkeji.bfinance.common.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import com.lexiangkeji.bfinance.BFinanceApplication;

public final class AppUtils {

    private AppUtils() {
        throw new UnsupportedOperationException("you can't instantiate me...");
    }

    // 获取App包名
    public static String getAppPackageName() {
        return BFinanceApplication.getInstants().getApplicationInfo().packageName;
    }

    /**
     * 获取程序的名字
     */
    public String getAppName() {
        //包管理操作管理类
        PackageManager pm = BFinanceApplication.getInstants().getPackageManager();
        try {
            ApplicationInfo info = pm.getApplicationInfo(getAppPackageName(), 0);
            return info.loadLabel(pm).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取程序 图标
     */
    public static Drawable getAppIcon() {
        try {
            //包管理操作管理类
            PackageManager pm = BFinanceApplication.getInstants().getPackageManager();
            //获取到应用信息
            ApplicationInfo info = pm.getApplicationInfo(getAppPackageName(), 0);
            return info.loadIcon(pm);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取程序的版本名称
     */
    public String getAppVersionName() {
        //包管理操作管理类
        PackageManager pm = BFinanceApplication.getInstants().getPackageManager();
        try {
            PackageInfo packinfo = pm.getPackageInfo(getAppPackageName(), 0);
            return packinfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }
        return "";
    }

    /**
     * 获取程序的版本号
     */
    public int getAppVersionCode() {
        //包管理操作管理类
        PackageManager pm = BFinanceApplication.getInstants().getPackageManager();
        try {
            PackageInfo packinfo = pm.getPackageInfo(getAppPackageName(), 0);
            return packinfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }
        return -1;
    }

}