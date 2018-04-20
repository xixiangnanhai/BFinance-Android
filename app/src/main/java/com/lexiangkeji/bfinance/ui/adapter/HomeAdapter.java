package com.lexiangkeji.bfinance.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lexiangkeji.bfinance.response.module.Product;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter {

    List<Product> data;

    public HomeAdapter(int item_homemain, @Nullable List<Product> data) {
        super(item_homemain,data);
        this.data=data;

    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Object o) {




    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
