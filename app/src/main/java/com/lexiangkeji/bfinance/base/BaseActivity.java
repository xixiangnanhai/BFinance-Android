package com.lexiangkeji.bfinance.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lexiangkeji.bfinance.manager.ActivityManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        if (types != null && types.length > 0) {
            Class<T> clazz = (Class<T>) types[0];
            try {
                presenter = (T) Class.forName(clazz.getCanonicalName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        ActivityManager.Instance().pushActivity(this);
    }


    @Override
    protected void onDestroy() {

        ActivityManager.Instance().outStackActivity(this);
        if (presenter != null) {
            presenter.recycle();
        }

        super.onDestroy();
    }

    public T getPresenter() {
        return presenter;
    }


}
