package com.lexiangkeji.bfinance.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.lexiangkeji.bfinance.R;
import com.lexiangkeji.bfinance.constant.Constant;
import com.lexiangkeji.bfinance.ui.fragment.PublicWebViewFragment;

public class WebviewActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_activty);
        String url=getIntent().getStringExtra(Constant.URL);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.content, PublicWebViewFragment.newInstance(url));
        transaction.commit();
    }
}
