package com.lexiangkeji.bfinance.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.ui.fragment.FindFragment;
import com.lexiangkeji.bfinance.ui.fragment.HomeMainFragment;
import com.lexiangkeji.bfinance.ui.fragment.MineFragment;

public class DataGenerator {
    public static final int[] mTabRes = new int[]{R.drawable.tab_home_selector, R.drawable.tab_discovery_selector, R.drawable.tab_profile_selector};
    public static final int[] mTabResPressed = new int[]{R.drawable.ic_tab_home_main_selected,   R.drawable.ic_tab_strip_icon_profile_selected,R.drawable.ic_tab_strip_icon_profile_selected};
    public static final String[] mTabTitle = new String[]{"首页", "发现", "我的"};

    public static Fragment[] getFragments() {
        Fragment fragments[] = new Fragment[3];
        fragments[0] = HomeMainFragment.newInstance();
        fragments[1] = FindFragment.newInstance();
        fragments[2] = MineFragment.newInstance();
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     *
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }


}
