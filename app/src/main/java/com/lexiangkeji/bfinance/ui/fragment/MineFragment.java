package com.lexiangkeji.bfinance.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.base.BaseFragment;

public class MineFragment extends BaseFragment {

    public static MineFragment newInstance() {
         Bundle args = new Bundle();
         MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View mRootView) {

    }

    public int setLayout() {
        return R.layout.fragment_mine;
    }


}
