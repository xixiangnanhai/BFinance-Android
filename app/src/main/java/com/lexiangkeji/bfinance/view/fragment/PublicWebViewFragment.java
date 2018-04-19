package com.lexiangkeji.bfinance.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.constant.Constant;

public class PublicWebViewFragment extends Fragment {


    private String stringUrl;
    private View contentView;

    public static PublicWebViewFragment newInstance(String url) {
         Bundle args = new Bundle();
         args.putString(Constant.URL,url);
         PublicWebViewFragment fragment = new PublicWebViewFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        stringUrl =  bundle.getString(Constant.URL);
        contentView = View.inflate(getContext(), R.layout.fragment_webview,null);
        initView(contentView);
        return contentView;

    }

    private void initView(View contentView) {



        WebView webView= (WebView) contentView.findViewById(R.id.webview);


    }
}
