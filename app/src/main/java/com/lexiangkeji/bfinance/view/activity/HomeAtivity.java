package com.lexiangkeji.bfinance.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.base.BaseActivity;
import com.lexiangkeji.bfinance.utils.DataGenerator;

import butterknife.ButterKnife;

public class HomeAtivity extends BaseActivity {



    FrameLayout homeContainer;

    TabLayout bottomTabLayout;

    private Fragment[] mFragmensts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        mFragmensts = DataGenerator.getFragments();
        bottomTabLayout=findViewById(R.id.bottom_tab_layout);
        homeContainer=findViewById(R.id.home_container);
        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());
                // Tab 选中之后，改变各个Tab的状态
                for (int i = 0; i < bottomTabLayout.getTabCount(); i++) {
                    View view = bottomTabLayout.getTabAt(i).getCustomView();
                    ImageView icon = (ImageView) view.findViewById(R.id.tab_content_image);
                    TextView text = (TextView) view.findViewById(R.id.tab_content_text);
                    if ( i == tab.getPosition() ) { // 选中状态
                        icon.setImageResource(DataGenerator.mTabResPressed[i]);
                        text.setTextColor(getResources().getColor(android.R.color.black));
                    } else {// 未选中状态
                        icon.setImageResource(DataGenerator.mTabRes[i]);
                        text.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    }
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // 提供自定义的布局添加Tab
        for (int i = 0; i < 3; i++) {
            bottomTabLayout.addTab(bottomTabLayout.newTab().setCustomView(DataGenerator.getTabView(this, i)));
        }


    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0://首页
                fragment = mFragmensts[0];
                break;
            case 1://发现
                fragment = mFragmensts[1];
                break;

            case 2://我的
                fragment = mFragmensts[2];
                break;

        }
        if ( fragment != null ) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }


}
