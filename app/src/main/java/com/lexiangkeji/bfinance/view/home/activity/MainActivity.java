package com.lexiangkeji.bfinance.view.home.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.common.base.activity.BaseActivity;
import com.lexiangkeji.bfinance.common.base.fragment.BaseFragment;
import com.lexiangkeji.bfinance.databinding.ActivityMainBinding;
import com.lexiangkeji.bfinance.view.find.fragment.FindFragment;
import com.lexiangkeji.bfinance.view.home.adapter.MainVPAdapter;
import com.lexiangkeji.bfinance.view.home.fragment.HomeFragment;
import com.lexiangkeji.bfinance.view.mine.fragment.MineFragment;
import com.lexiangkeji.bfinance.view.weight.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private MainVPAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        showContentView();

    }

    @Override
    protected boolean needTitleBar() {
        return false;
    }

    private void initData() {
        List<BaseFragment> tempData = new ArrayList<>();
        tempData.add(HomeFragment.newInstance());
        tempData.add(FindFragment.newInstance());
        tempData.add(MineFragment.newInstance());
        mAdapter = new MainVPAdapter(getSupportFragmentManager(), tempData);

        mBinding.nsvpFragmentContainerMainActivity.setOffscreenPageLimit(tempData.size());
        mBinding.nsvpFragmentContainerMainActivity.setAdapter(mAdapter);

        mBinding.tlTabContainerMainActivity.setupWithViewPager(mBinding.nsvpFragmentContainerMainActivity);

    }

}
