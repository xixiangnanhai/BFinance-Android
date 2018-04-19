package com.lexiangkeji.bfinance.base;

import android.content.Context;

/**
 * 公共View接口
 *
 * @author Ht
 */
public interface IBaseView {

    /**
     * 显示可取消的无文字进度条
     */
    void showProgress();

    /**
     * 隐藏进度条
     */
    void hideProgress();

    /**
     * 获取当前上下文对象
     *
     * @return
     */
    Context getContext();

    /**
     * 结束当前页面
     */
    void close();

}
