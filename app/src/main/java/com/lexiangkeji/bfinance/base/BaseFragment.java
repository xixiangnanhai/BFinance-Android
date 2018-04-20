package com.lexiangkeji.bfinance.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder mUnbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  mRootView=View.inflate(getContext(), setLayout(),null);
        mUnbinder=  ButterKnife.bind(this, mRootView);
        initView(mRootView);
        return mRootView;

    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mUnbinder != Unbinder.EMPTY){
            mUnbinder.unbind();
        }
    }

    protected abstract void initView(View mRootView);

    public abstract int setLayout() ;
}
