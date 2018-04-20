package com.lexiangkeji.bfinance.app_api.widget;

import android.view.View;

import com.lexiangkeji.bfinance.app_api.utils.Toaster;

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2017/7/28 0028
 * 描述:
 * 历史:<br/>
 * ================================================
 */
public class ClickProxy  implements View.OnClickListener {
    private View.OnClickListener origin;
    private long lastclick = 0;
    private long timems = 1000; //ms
    private IAgain mIAgain;

    public ClickProxy(View.OnClickListener origin, long timems, IAgain again) {
        this.origin = origin;
        this.mIAgain = again;
        this.timems = timems;
    }

    public ClickProxy(View.OnClickListener origin) {
        this.origin = origin;
    }

    @Override
    public void onClick(View v) {
        if (System.currentTimeMillis() - lastclick >= timems) {
            origin.onClick(v);
            lastclick = System.currentTimeMillis();
        } else {
            if (mIAgain != null) mIAgain.onAgain();
            Toaster.showToast("请放松下,频率有点快啊");
        }
    }

    public interface IAgain {
        void onAgain();//重复点击
    }


}


