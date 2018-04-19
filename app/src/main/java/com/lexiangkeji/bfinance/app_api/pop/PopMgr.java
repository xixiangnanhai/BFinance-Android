package com.lexiangkeji.bfinance.app_api.pop;

import com.tencent.bugly.beta.UpgradeInfo;

import java.util.TreeMap;

/**
 * Created by Eric.Gao on 2017/11/15.
 */

public class PopMgr {

    //值越小, 优先级越高
    public static final int POP_OPERATION = 0x12;
    public static final int POP_UPGRADE = 0x11;
    public static final int POP_TOKEN_ERROR = 0x10;

    private static PopMgr mInstance;
    private PopCallback mListener;

    //使用treemap控制弹窗任务队列, 即使是后加入的任务,只要值较小, 就可以优先执行
    private TreeMap<Integer, Object> mPopDataTree;

    private PopMgr() {
        mPopDataTree = new TreeMap<>();
    }

    public static PopMgr getInstance() {
        if (mInstance == null) {
            mInstance = new PopMgr();
        }
        return mInstance;
    }

    private void insertTask(Integer key, Object obj) {
        // 如果key已经存在，treeMap中默认object会刷新，int会自动从小到大排序
        mPopDataTree.put(key, obj);
        if (mPopDataTree.size() == 1) {//如果是第一个, 那么直接执行
            mListener.shouldPop(mPopDataTree.firstKey(), mPopDataTree.get(mPopDataTree.firstKey()));
        }
    }

    private void removeTask(Integer key) {
        if (mPopDataTree.containsKey(key)) {
            mPopDataTree.remove(key);
        }
    }

    private void removeFirstPop() {
        if (mPopDataTree.size() > 0) {
            mPopDataTree.remove(mPopDataTree.firstKey());
        }
    }

    public void nextTask() {
        removeFirstPop();
        if (mPopDataTree.size() > 0) {
            mListener.shouldPop(mPopDataTree.firstKey(), mPopDataTree.get(mPopDataTree.firstKey()));
        }
    }

    public void startUpgrade(UpgradeInfo upgradeInfo, boolean isManual) {
        if (upgradeInfo == null) {
            return;
        }
//        if (upgradeInfo.versionCode > BuildConfig.VERSION_CODE) {
//            if (mListener != null) {
//                //转化数据体
//                UpgradeModel model = new UpgradeModel();
//                model.setForceUpgrade(upgradeInfo.upgradeType == 2);//升级策略 1建议 2强制 3手工
//                model.setUpgradeContent(upgradeInfo.newFeature);
//                model.setUpgradeTitle(upgradeInfo.title);
//                model.setVersionName(upgradeInfo.versionName);
//                model.setVersionCode(upgradeInfo.versionCode);
//                model.setIsManual(isManual);
//                insertTask(POP_UPGRADE, model);
//            }
//        }
//        RxBus.getDefault().send(UpdatePopEvent.INSTANCE);//1.4之后去除
    }

    /**
     * 显示token错误的dialog
     */
    public void showTokenErrorDialog(String errorMsg) {
        if (mListener != null) {
            insertTask(POP_TOKEN_ERROR, errorMsg);
        }
    }

//    //显示运营活动弹窗
//    public void showOperationDialog(HomeInfoResultModel.ActivityInfoBean activityInfoBean) {
//        if (mListener != null) {
//            insertTask(POP_OPERATION, activityInfoBean);
//        }
//    }

    public void setPopCallback(PopCallback popCallback) {
        mListener = popCallback;
    }

    public void removePopCallback() {
        mListener = null;
    }

    public interface PopCallback {
        void shouldPop(int popType, Object obj);
    }
}
