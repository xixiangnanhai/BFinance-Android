package com.lexiangkeji.bfinance.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.base.BaseFragment;
import com.lexiangkeji.bfinance.constant.Constant;
import com.lexiangkeji.bfinance.imageloader.ImageLoader;
import com.lexiangkeji.bfinance.response.HomeResulInforModel;
import com.lexiangkeji.bfinance.response.module.Product;
import com.lexiangkeji.bfinance.ui.activity.WebviewActivty;
import com.lexiangkeji.bfinance.ui.adapter.HomeAdapter;
import com.lexiangkeji.bfinance.widget.BannerLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeMainFragment extends BaseFragment implements OnRefreshListener, BaseQuickAdapter.OnItemClickListener {


    RecyclerView recyclerView;

    SmartRefreshLayout refreshLayout;
    private TextView tv_account_people;
    private TextView tv_account_yuan;
    private HomeAdapter homeAdapter;
    private HomeResulInforModel homeResponse;

    public static HomeMainFragment newInstance() {
        Bundle args = new Bundle();
        HomeMainFragment fragment = new HomeMainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int setLayout() {
        return R.layout.fragment_home_main;
    }




    @Override
    public void initView(View contentview) {
        recyclerView=contentview.findViewById(R.id.recyclerView);
        refreshLayout=contentview.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setEnableLoadMore(false);
        Gson gson=new Gson();
        homeResponse = gson.fromJson(Constant.Homefirst,HomeResulInforModel.class);
        //头的初始化
        View headView=View.inflate(getContext(),R.layout.layout_main_head,null);
        BannerLayout banner= (BannerLayout) headView.findViewById(R.id.banner);
        banner.setImageLoader(new ImgLoader());
        List<String> urls=new ArrayList<String>();
        List<HomeResulInforModel.DataBean.BannerListBean> bannerListBeans= homeResponse.getData().getBannerList();
        for (int i = 0; i < bannerListBeans.size(); i++) {
            urls.add(bannerListBeans.get(i).getImageUrl());
        }
        banner.setViewUrls(urls);
        banner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                HomeResulInforModel.DataBean.BannerListBean bannerListBean=homeResponse.getData().getBannerList().get(position);
                String jumpurl=bannerListBean.getJumpUrl();
                Intent intent=new Intent(getContext(),WebviewActivty.class);
                intent.putExtra(Constant.URL,jumpurl);
                startActivity(intent);

            }
        });



        //尾部的初始化
        View footview=View.inflate(getContext(),R.layout.layout_main_foot,null);
        tv_account_people = (TextView) footview.findViewById(R.id.tv_aacount_people);
        tv_account_yuan = (TextView) footview.findViewById(R.id.tv_account_yuan);
        //模拟数据

        homeAdapter = new HomeAdapter(R.layout.item_homemain, homeResponse.getData().getProductList());
        LinearLayoutManager linearLayout=new LinearLayoutManager(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        homeAdapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(homeAdapter);
        //加头加尾巴
        homeAdapter.addHeaderView(headView);
        homeAdapter.addFooterView(footview);
        tv_account_people.setText(homeResponse.getData().getInvestInfo().getPopulationDes());
        tv_account_yuan.setText(homeResponse.getData().getInvestInfo().getAmountDes());

        }





    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
        List<Product> products=baseQuickAdapter.getData();





    }
    class  ImgLoader implements BannerLayout.ImageLoader{


        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            ImageLoader.load(path,imageView);
        }
    }
}
