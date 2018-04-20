package com.lexiangkeji.bfinance.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.base.BaseFragment;

public class FindFragment extends BaseFragment {


    public static FindFragment newInstance() {
         Bundle args = new Bundle();
         FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View mRootView) {

    }

    @Override
    public int setLayout() {
        return R.layout.fragment_find;
    }


}
