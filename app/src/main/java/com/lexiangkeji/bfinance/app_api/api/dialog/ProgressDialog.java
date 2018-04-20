package com.lexiangkeji.bfinance.app_api.api.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.lexiangkeji.bfinance.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by mateng on 2017/7/14.
 * <p>
 * 加载框
 */

public class ProgressDialog extends DialogFragment implements DialogInterface.OnKeyListener {

    private final int TIMEOUT = 30;
    private boolean isAdded = false;
    private OnCancelListener onCancelListener;
    private int runTime;
    private Timer timer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setOnKeyListener(this);
        return inflater.inflate(R.layout.dialog_progress, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runTime++;
                if (runTime == TIMEOUT) {
                    dismissAllowingStateLoss();
                }
            }
        };

        timer = new Timer(true);
        timer.schedule(timerTask, 1000, 1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        isAdded = false;

        return super.onCreateDialog(savedInstanceState);
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (onCancelListener != null) {
            onCancelListener.onCancel();
        }
    }

    // 按键的坚挺
    @Override
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == KeyEvent.KEYCODE_BACK){
            dismiss();
            return true;
        }
        return false;
    }

    public interface OnCancelListener {
        void onCancel();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        if (!isAdded) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.add(this, tag);
            ft.commitAllowingStateLoss();
            isAdded = true;
        }
    }

    //
    @Override
    public void dismiss() {
        dismissAllowingStateLoss();
    }

    @Override
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
//        ObjectAnimator animator = ObjectAnimator.ofFloat(getView(), "alpha", 1f, 0f);
//        animator.setDuration(1000);
//        animator.setInterpolator(new LinearInterpolator());
//        animator.start();
//
//        animator.addUpdateListener(animation -> {
//            if (getDialog() == null)
//                return;
//            WindowManager.LayoutParams lp = getDialog().getWindow().getAttributes();
//            lp.dimAmount = (float) animation.getAnimatedValue();
//            getDialog().getWindow().setAttributes(lp);
//        });
//
//
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                ProgressDialog.super.dismissAllowingStateLoss();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        Window window = getDialog().getWindow();
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.0f;

        window.setAttributes(windowParams);
    }
}
