package com.lexiangkeji.bfinance.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lexiangkeji.bfinance.R;


/**
 * Created by Eric.Gao on 2018/1/6.
 * 窗口对话框
 * 默认两个按钮，左侧取消按钮，右侧确定按钮
 * 调用时如不需修改按钮的文案则不需要进行设置，使用默认就行
 */

public class HSWindowDialog extends Dialog implements View.OnClickListener {


    private TextView mTitleTv;
    private TextView mMessageTv;
    private TextView mCancelTv;
    private TextView mConfirmTv;

    private int mDialogType;
    private String mTitle;
    private int mActionType;
    private Object mExtra;

    private OnDialogClickListener mOnDialogClickListener;

    public HSWindowDialog(@NonNull Context context) {
        super(context, R.style.WindowDialogStyle);
        init(context);
    }

    protected void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_window, null);
        addContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        setCancelable(false);// 点击返回键关闭
        setCanceledOnTouchOutside(false);// 点击外部关闭
        // 设置对话框的宽度
        int screenWidth = getScreenWidth(context);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (screenWidth * 0.8); //设置宽度
        getWindow().setAttributes(lp);
        initView();
        reset();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
    }


    private void initView() {
        mTitleTv = (TextView) findViewById(R.id.tv_title);
        mMessageTv = (TextView) findViewById(R.id.tv_message);
        mCancelTv = (TextView) findViewById(R.id.tv_cancel);
        mConfirmTv = (TextView) findViewById(R.id.tv_confirm);
    }

    private void initListener() {
        mCancelTv.setOnClickListener(this);
        mConfirmTv.setOnClickListener(this);
    }

    public HSWindowDialog dialogType(int dialogType) {
        this.mDialogType = dialogType;
        return this;
    }

    public HSWindowDialog actionType(int actionType) {
        this.mActionType = actionType;
        return this;
    }

    public HSWindowDialog extra(Object object) {
        this.mExtra = object;
        return this;
    }


    public HSWindowDialog title(String title) {
        this.mTitle = title;
        mTitleTv.setText(title);
        return this;
    }

    public HSWindowDialog message(String message) {
        if (message.contains("##")) {
            message = message.replaceAll("##", "\n");
        }
        mMessageTv.setText(message);
        return this;
    }

    public HSWindowDialog centered(boolean centered) {
        if (centered) {
            mMessageTv.setGravity(Gravity.CENTER_HORIZONTAL);
        } else {
            mMessageTv.setGravity(Gravity.NO_GRAVITY);
        }
        return this;
    }

    public HSWindowDialog confirmStr(String confirmStr) {
        this.mConfirmTv.setText(confirmStr);
        return this;
    }

    public HSWindowDialog cancelStr(String cancelStr) {
        this.mCancelTv.setText(cancelStr);
        return this;
    }

    public HSWindowDialog listener(OnDialogClickListener listener) {
        this.mOnDialogClickListener = listener;
        return this;
    }

    public void show() {
        if (TextUtils.isEmpty(mTitle)) {// 不显示标题
            mTitleTv.setVisibility(View.GONE);
        } else {
            mTitleTv.setVisibility(View.VISIBLE);
        }

        if (mDialogType == DialogType.SINGLE.value) {//单一按钮
            mCancelTv.setVisibility(View.GONE);
            ((LinearLayout.LayoutParams) mConfirmTv.getLayoutParams()).leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.x70);
            ((LinearLayout.LayoutParams) mConfirmTv.getLayoutParams()).rightMargin = getContext().getResources().getDimensionPixelSize(R.dimen.x70);
        } else {
            mCancelTv.setVisibility(View.VISIBLE);
            ((LinearLayout.LayoutParams) mConfirmTv.getLayoutParams()).leftMargin = 0;
            ((LinearLayout.LayoutParams) mConfirmTv.getLayoutParams()).rightMargin = 0;
        }
        super.show();
    }

    public void reset() {
        this.dialogType(DialogType.DEFAULT.value);
        this.title("");
        this.message("");
        this.centered(false);
        this.cancelStr("取消");
        this.confirmStr("确定");
        this.actionType(0);
        this.extra(null);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_cancel) {
            if (mOnDialogClickListener != null) {
                mOnDialogClickListener.onCancel(v, mActionType, mExtra);
            }
            dismiss();
        } else if (i == R.id.tv_confirm) {
            if (mOnDialogClickListener != null) {
                mOnDialogClickListener.onConfirm(v, mActionType, mExtra);
            }
            dismiss();
        }

    }

    /**
     * 得到屏幕的宽度
     *
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        // 低于版本13的
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB_MR2) {
            return display.getWidth();
        } else {
            Point point = new Point();
            display.getSize(point);
            return point.x;
        }
    }

    public static interface OnDialogClickListener {
        void onConfirm(View v, int actionType, Object extra);

        void onCancel(View v, int actionType, Object extra);
    }

    /**
     * 类型
     */
    public enum DialogType {

        DEFAULT(0),//失败
        SINGLE(1);// 单一按钮
        public final int value;

        DialogType(int value) {
            this.value = value;
        }
    }


}
