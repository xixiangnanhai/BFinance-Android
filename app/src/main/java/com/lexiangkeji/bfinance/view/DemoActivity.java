package com.lexiangkeji.bfinance.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lexiangkeji.bfinance.R;

public class DemoActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestData();
            }
        });

    }

    private void requestData() {

//        RxHttpUtils.createHttpRequest()
//
//                RxHttpUtils.createHttpRequest(AppService.INSTANCE.http_getHomeInfo(listIndex, Constants.PAGE_SIZE, status))
//                        .subscribe(new BaseSubscriber<HuaShengBaseResponse<RegularDetailListModel>>(this) {
//                            @Override
//                            public void onResult(HuaShengBaseResponse<RegularDetailListModel> regularDetailListModelHuaShengBaseResponse) {
//                                if (regularDetailListModelHuaShengBaseResponse != null) {
//                                    RegularDetailListModel model = regularDetailListModelHuaShengBaseResponse.data;
//                                    fillData(model);
//                                }
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                super.onError(e);
//                                mBinding.srlContainer.finishRefresh();
//                                mBinding.srlContainer.finishLoadmore();
//                            }
//
//                            @Override
//                            public void onCompleted() {
//                                super.onCompleted();
//                                mBinding.srlContainer.finishRefresh();
//                                mBinding.srlContainer.finishLoadmore();
//                            }
//                        });


    }
}
