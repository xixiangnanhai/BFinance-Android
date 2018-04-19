package com.lexiangkeji.bfinance.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private Unbinder mUnbinder;
    private T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        if (types != null && types.length > 0) {
            Class<T> clazz = (Class<T>) types[0];
            try {
                presenter = (T) Class.forName(clazz.getCanonicalName()).newInstance();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = View.inflate(getContext(), setLayout(), null);
        mUnbinder = ButterKnife.bind(this, mRootView);

        initView(mRootView);
        return mRootView;

    }

    @Override
    public void onDestroy() {

        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }

        if (presenter != null) {
            presenter.recycle();
        }

        super.onDestroy();
    }

    protected abstract void initView(View mRootView);

    public abstract int setLayout();

    public T getPresenter() {
        return presenter;
    }
}
