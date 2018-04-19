package com.lexiangkeji.bfinance.app_api.manager;

import android.app.Activity;

import com.blankj.utilcode.util.LogUtils;

import java.util.Stack;

public class HuaShengActivityManager {

    private final String TAG = HuaShengActivityManager.class.getSimpleName();
    private Stack<Activity> mActivityStack;
    private static HuaShengActivityManager mActivityManager;

    private HuaShengActivityManager() {
        mActivityStack = new Stack<>();
    }

    /**
     * 单一实例
     */
    public static HuaShengActivityManager getInstance() {
        if (mActivityManager == null) {
            mActivityManager = new HuaShengActivityManager();
        }
        return mActivityManager;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<Activity>();
        }
        mActivityStack.push(activity);
    }

    public boolean hasActivity(Class<?> cls) {
        boolean result = false;
        for (Activity activity : mActivityStack) {
            if (null != activity && activity.getClass().equals(cls)) {//3.2 解决听云bug，https://report.tingyun.com/mobile/mobileApp/7421/crashDetail?endTime=2016-10-21+11%3A12&timePeriod=30&crashReportId=0&mobileCrashId=36330203&mobileAppVersionId=92778
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = null;
        try {
            activity = mActivityStack.lastElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {

        Activity activity = null;
        try {
            activity = mActivityStack.lastElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            activity.finish();
        }
    }

    public void removeActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
        }
    }


    public boolean isTopActivity(Class<?> clz) {
        boolean result = false;
        Activity activity = currentActivity();
        if (null == activity) {
            return result;
        }
        if (activity.getClass().equals(clz)) {
            result = true;
        }
        return result;
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        Stack<Activity> deleteActivityStack = new Stack<Activity>();
        for (Activity activity : mActivityStack) {

            if (null != activity && activity.getClass().equals(cls)) {
                deleteActivityStack.add(activity);
            }
        }

        mActivityStack.removeAll(deleteActivityStack);
        for (Activity activity : deleteActivityStack) {
            if (null != activity) {
                activity.finish();
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = mActivityStack.size(); i < size; i++) {
            if (null != mActivityStack.get(i)) {
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }

    /**
     * 结束除指定activity以外的所有activity
     *
     * @param clazz
     */
    public void finishAllActivityWithOutThis(Class<?> clazz) {
        Activity activity = null;
        for (int i = 0, size = mActivityStack.size(); i < size; i++) {
            Activity current = mActivityStack.get(i);
            if (current != null
                    && !current.getClass().getSimpleName()
                    .equals(clazz.getSimpleName())) {
                mActivityStack.get(i).finish();
            } else {
                activity = current;
            }
        }
        mActivityStack.clear();
        mActivityStack.add(activity);
    }


    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            LogUtils.e(TAG, e.toString());
        }
    }

}