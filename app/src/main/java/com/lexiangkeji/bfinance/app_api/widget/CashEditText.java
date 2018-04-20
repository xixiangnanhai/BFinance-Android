package com.lexiangkeji.bfinance.app_api.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by Eric.Gao on 2015/3/24.
 */
public class CashEditText extends AppCompatEditText {
    public CashEditText(Context context) {
        super(context);
    }

    public CashEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CashEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private OnTextChangedListener onTextChangedListener = null;

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.onTextChangedListener = onTextChangedListener;
    }

    @Override
    protected void onTextChanged(CharSequence charSequence, int start, int lengthBefore, int lengthAfter) {

        if (charSequence.toString().contains(".") && charSequence.length() - 1 - charSequence.toString().indexOf(".") > 2) {
            charSequence = charSequence.toString().subSequence(0, charSequence.toString().indexOf(".") + 3);
            setText(charSequence);
            setSelection(charSequence.length());
            return;
        }

        if (charSequence.toString().trim().substring(0).equals(".")) {
            charSequence = "0" + charSequence;
            setText(charSequence);
            setSelection(2);
            return;
        }

        if (charSequence.toString().startsWith("0") && charSequence.toString().trim().length() > 1
                && !charSequence.toString().substring(1, 2).equals(".")) {
            setText(charSequence.subSequence(0, 1));
            setSelection(1);
            return;
        }


        if (onTextChangedListener != null) {
            onTextChangedListener.onTextChanged(charSequence, start, lengthBefore, lengthAfter);
        }
    }

    public interface OnTextChangedListener {
        void onTextChanged(CharSequence charSequence, int start, int lengthBefore, int lengthAfter);
    }

}
