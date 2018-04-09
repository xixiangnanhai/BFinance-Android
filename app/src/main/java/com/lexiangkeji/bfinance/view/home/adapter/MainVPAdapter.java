package com.lexiangkeji.bfinance.view.home.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lexiangkeji.bfinance.common.base.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 樊磊 on 2018/4/3.
 */

public class MainVPAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> myData;


    public MainVPAdapter(FragmentManager fm, List<BaseFragment> myData) {
        super(fm);
        this.myData = myData;
    }

    @Override
    public Fragment getItem(int position) {
        return myData.get(position);
    }

    @Override
    public int getCount() {
        return myData == null ? 0 : myData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return position + 1 + "页";
    }
}
