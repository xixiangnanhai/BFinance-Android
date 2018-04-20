package com.lexiangkeji.bfinance.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lexiangkeji.bfinance.R;

import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class HSToolbar extends ViewGroup implements View.OnClickListener {
    private static final int DEFAULT_MAIN_TEXT_SIZE = 18;
    private static final int DEFAULT_SUB_TEXT_SIZE = 12;
    private static final int DEFAULT_ACTION_TEXT_SIZE = 14;
    private static final int DEFAULT_TITLE_BAR_HEIGHT = 48;

    private static final int INVALID_VAL = -1;
    private static final int COLOR_DEFAULT = Color.parseColor("#ffffff");

    private LinearLayout mLeftLayout;
    private LinearLayout mRightLayout;
    private LinearLayout mRedPointLayout;
    private LinearLayout mCenterLayout;
    private ImageView mLeftImageView;
    private ImageView mLeftClose;
    private TextView mCenterText;
    private ImageView mCenterImageView;
    private TextView mSubTitleText;
    private View mCustomCenterView;
    private View mDividerView;
    private ImageView mRedPointImageView;

    private boolean mImmersive;

    private int mScreenWidth;
    private int mStatusBarHeight;
    private int mActionPadding;
    private int mOutPadding;
    private int mRedPointLayoutWidth;
    private int mActionTextColor;
    private ColorStateList mColorStateList;
    private int mHeight;

    private WeakReference<Context> mContext;

    public HSToolbar(Context context) {
        super(context);
        mContext = new WeakReference<>(context);
        init(context);
    }

    public HSToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = new WeakReference<>(context);
        init(context);
    }

    public HSToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = new WeakReference<>(context);
        init(context);
    }

    private void init(Context context) {
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        if (mImmersive) {
            mStatusBarHeight = getSystemStatusBarHeight();
        }
        mActionPadding = dip2px(5);
        mOutPadding = dip2px(12);
        mRedPointLayoutWidth = dip2px(17);
        mHeight = dip2px(DEFAULT_TITLE_BAR_HEIGHT);
        initView(context);
    }

    private void initView(Context context) {
        mLeftLayout = new LinearLayout(context);
        mCenterLayout = new LinearLayout(context);
        mRightLayout = new LinearLayout(context);
        mRedPointLayout = new LinearLayout(context);
        mDividerView = new View(context);

        LayoutParams leftLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);

        mLeftImageView = new ImageView(context);
        mLeftImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        mLeftImageView.setPadding(mOutPadding + mActionPadding * 2, 0, 0, 0);
        LayoutParams leftImageParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);

        mLeftClose = new ImageView(context);
        mLeftClose.setScaleType(ImageView.ScaleType.FIT_CENTER);

        LinearLayout.LayoutParams leftCloseParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        leftCloseParams.leftMargin = dip2px(30);
        mLeftLayout.addView(mLeftImageView, leftImageParams);
        mLeftLayout.addView(mLeftClose, leftCloseParams);

        mCenterText = new TextView(context);
        mSubTitleText = new TextView(context);
        mCenterImageView = new ImageView(context);
        mCenterLayout.addView(mCenterText);
        mCenterLayout.addView(mSubTitleText);
        mCenterLayout.addView(mCenterImageView);

        mCenterLayout.setGravity(Gravity.CENTER);
        mCenterText.setTextSize(DEFAULT_MAIN_TEXT_SIZE);
        mCenterText.setSingleLine();
        mCenterText.setGravity(Gravity.CENTER);
        mCenterText.setEllipsize(TextUtils.TruncateAt.END);

        mSubTitleText.setTextSize(DEFAULT_SUB_TEXT_SIZE);
        mSubTitleText.setSingleLine();
        mSubTitleText.setGravity(Gravity.CENTER);
        mSubTitleText.setEllipsize(TextUtils.TruncateAt.END);

        mCenterImageView.setVisibility(GONE);

        LinearLayout.LayoutParams rightLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rightLayoutParams.rightMargin = mRedPointLayoutWidth;
        mRightLayout.setPadding(mOutPadding, 0, 0, 0);

        LinearLayout.LayoutParams redPointLayoutParams = new LinearLayout.LayoutParams(mRedPointLayoutWidth, LayoutParams.MATCH_PARENT);

        mRedPointImageView = new ImageView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dip2px(8), dip2px(8));
        params.topMargin = dip2px(8);
        mRedPointImageView.setLayoutParams(params);
        mRedPointImageView.setImageResource(R.drawable.tinny_red_point);

        addView(mLeftLayout, leftLayoutParams);
        addView(mCenterLayout);
        addView(mRightLayout, rightLayoutParams);
        addView(mRedPointLayout, redPointLayoutParams);
        addView(mDividerView, new LayoutParams(LayoutParams.MATCH_PARENT, 1));

        mRedPointLayout.addView(mRedPointImageView);
        mRedPointImageView.setVisibility(View.INVISIBLE);
    }

    public void setImmersive(boolean immersive, Activity activity, @ColorInt int color) {
        mImmersive = immersive;
        if (mImmersive) {
            mStatusBarHeight = getSystemStatusBarHeight();
            if (color != INVALID_VAL) {
                compat(activity, color);
            } else {
                compat(activity, INVALID_VAL);
            }
        } else {
            mStatusBarHeight = 0;
        }
    }

    public void compat(Activity activity, int statusColor) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            mStatusBarHeight = 0;
        }

        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (statusColor != INVALID_VAL) {
                activity.getWindow().setStatusBarColor(statusColor);
                mStatusBarHeight = 0;
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int color = COLOR_DEFAULT;
            ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
            if (statusColor != INVALID_VAL) {
                color = statusColor;
            }
            View statusBarView = new View(activity);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                    getStatusBarHeight());
            statusBarView.setBackgroundColor(color);
            contentView.addView(statusBarView, lp);
        }

    }

    public int getStatusBarHeight() {
        return mStatusBarHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
        setMeasuredDimension(getMeasuredWidth(), mHeight);
    }

    public void setLeftImageResource(int resId) {
        mLeftImageView.setImageResource(resId);
    }

    public void setLeftImageClickListener(OnClickListener l) {
        mLeftImageView.setOnClickListener(l);
    }

    public void setLeftCloseClickListener(OnClickListener l) {
        mLeftClose.setOnClickListener(l);
    }

    public void setLeftImageVisible(boolean visible) {
        mLeftImageView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setLeftCloseVisible(boolean visible) {
        mLeftClose.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setLeftCloseImage(@DrawableRes int leftCloseImage) {
        mLeftClose.setImageResource(leftCloseImage);
    }

    public void setTitle(CharSequence title) {
        mCenterImageView.setVisibility(GONE);
        int index = title.toString().indexOf("\n");
        if (index > 0) {
            setTitle(title.subSequence(0, index), title.subSequence(index + 1, title.length()), LinearLayout.VERTICAL);
        } else {
            index = title.toString().indexOf("\t");
            if (index > 0) {
                setTitle(title.subSequence(0, index), "  " + title.subSequence(index + 1, title.length()), LinearLayout.HORIZONTAL);
            } else {
                mCenterText.setText(title);
                mSubTitleText.setVisibility(View.GONE);
            }
        }
    }

    public void setImageTitle(int resId) {
        mCenterImageView.setVisibility(VISIBLE);
        mCenterText.setVisibility(GONE);
        mSubTitleText.setVisibility(View.GONE);
        mCenterImageView.setBackgroundResource(resId);
    }

    private void setTitle(CharSequence title, CharSequence subTitle, int orientation) {
        mCenterLayout.setOrientation(orientation);
        mCenterText.setText(title);

        mSubTitleText.setText(subTitle);
        mSubTitleText.setVisibility(View.VISIBLE);
    }

    public void setCenterClickListener(OnClickListener l) {
        mCenterLayout.setOnClickListener(l);
    }

    public void setTitle(int resid) {
        setTitle(getResources().getString(resid));
    }

    public void setTitleColor(int resid) {
        mCenterText.setTextColor(resid);
    }

    public void setTitleStyle(int style) {
        Context context = mContext.get();
        if (context != null) {
            mCenterText.setTextAppearance(context, style);
        }
    }

    public void setTitleSize(float size) {
        mCenterText.setTextSize(size);
    }

    public void setTitleBackground(int resid) {
        mCenterText.setBackgroundResource(resid);
    }

    public void setSubTitleColor(int resid) {
        mSubTitleText.setTextColor(resid);
    }

    public void setSubTitleSize(float size) {
        mSubTitleText.setTextSize(size);
    }

    public void setCustomTitle(View titleView) {
        if (titleView == null) {
            mCenterText.setVisibility(View.VISIBLE);
            if (mCustomCenterView != null) {
                mCenterLayout.removeView(mCustomCenterView);
            }

        } else {
            if (mCustomCenterView != null) {
                mCenterLayout.removeView(mCustomCenterView);
            }
            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            mCustomCenterView = titleView;
            mCenterLayout.addView(titleView, layoutParams);
            mCenterText.setVisibility(View.GONE);
        }
    }

    public void setDivider(Drawable drawable) {
        mDividerView.setBackgroundDrawable(drawable);
    }

    public void setDividerColor(int color) {
        mDividerView.setBackgroundColor(color);
    }

    public void setDividerHeight(int dividerHeight) {
        mDividerView.getLayoutParams().height = dividerHeight;
    }

    public void setActionTextColor(int colorResId) {
        mActionTextColor = colorResId;
    }

    public void setActionTextColorStateList(ColorStateList colorStateList) {
        mColorStateList = colorStateList;
    }

    /**
     * Function to set a click listener for Title TextView
     *
     * @param listener the onClickListener
     */
    public void setOnTitleClickListener(OnClickListener listener) {
        mCenterText.setOnClickListener(listener);
    }

    @Override
    public void onClick(View view) {
        final Object tag = view.getTag();
        if (tag instanceof Action) {
            final Action action = (Action) tag;
            action.performAction(view);
        }
    }

    /**
     * Adds a list of {@link Action}s.
     *
     * @param actionList the actions to add
     */
    public void addActions(ActionList actionList) {
        int actions = actionList.size();
        for (int i = 0; i < actions; i++) {
            addAction(actionList.get(i));
        }
    }

    /**
     * Adds a new {@link Action}.
     *
     * @param action the action to add
     */
    public View addAction(Action action) {
        final int index = mRightLayout.getChildCount();
        return addAction(action, index);
    }

    /**
     * Adds a new {@link Action} at the specified index.
     *
     * @param action the action to add
     * @param index  the position at which to add the action
     */
    public View addAction(Action action, int index) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        View view = inflateAction(action);
        mRightLayout.addView(view, index, params);
        return view;
    }

    /**
     * Removes all action views from this action bar
     */
    public void removeAllActions() {
        mRightLayout.removeAllViews();
    }

    /**
     * Remove a action from the action bar.
     *
     * @param index position of action to remove
     */
    public void removeActionAt(int index) {
        mRightLayout.removeViewAt(index);
    }

    /**
     * Remove a action from the action bar.
     *
     * @param action The action to remove
     */
    public void removeAction(Action action) {
        int childCount = mRightLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = mRightLayout.getChildAt(i);
            if (view != null) {
                final Object tag = view.getTag();
                if (tag instanceof Action && tag.equals(action)) {
                    mRightLayout.removeView(view);
                }
            }
        }
    }

    /**
     * Returns the number of actions currently registered with the action bar.
     *
     * @return action count
     */
    public int getActionCount() {
        return mRightLayout.getChildCount();
    }

    /**
     * Inflates a {@link View} with the given {@link Action}.
     *
     * @param action the action to inflate
     * @return a view
     */
    private View inflateAction(Action action) {
        View view = null;
        if (TextUtils.isEmpty(action.getText())) {
            ImageView img = new ImageView(getContext());
            img.setImageResource(action.getDrawable());
            view = img;
        } else {
            TextView text = new TextView(getContext());
            text.setGravity(Gravity.CENTER);
            text.setText(action.getText());
            text.setTextSize(DEFAULT_ACTION_TEXT_SIZE);
            if (mColorStateList != null) {
                text.setTextColor(mColorStateList);
            } else if (mActionTextColor != 0) {
                text.setTextColor(mActionTextColor);
            }
            view = text;
        }
        view.setPadding(2 * mActionPadding, 0, 0, 0);
        view.setTag(action);
        view.setOnClickListener(this);
        return view;
    }

    public View getViewByAction(Action action) {
        View view = findViewWithTag(action);
        return view;
    }

    public void showRedPointView() {
        if (mRedPointImageView != null && mRedPointImageView.getVisibility() == View.INVISIBLE) {
            mRedPointImageView.setVisibility(View.VISIBLE);
        }
    }

    public void hideRedPointView() {
        if (mRedPointImageView != null && mRedPointImageView.getVisibility() == View.VISIBLE) {
            mRedPointImageView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height;
        if (heightMode != MeasureSpec.EXACTLY) {
            height = mHeight + mStatusBarHeight;
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mHeight, MeasureSpec.EXACTLY);
        } else {
            height = MeasureSpec.getSize(heightMeasureSpec) + mStatusBarHeight;
        }

        measureChild(mLeftLayout, widthMeasureSpec, heightMeasureSpec);
        measureChild(mRightLayout, widthMeasureSpec, heightMeasureSpec);
        measureChild(mRedPointLayout, widthMeasureSpec, heightMeasureSpec);
        if (mLeftLayout.getMeasuredWidth() > mRightLayout.getMeasuredWidth() + mRedPointLayout.getMeasuredWidth()) {
            mCenterLayout.measure(
                    MeasureSpec.makeMeasureSpec(mScreenWidth - 2 * mLeftLayout.getMeasuredWidth(), MeasureSpec.EXACTLY)
                    , heightMeasureSpec);
        } else {
            mCenterLayout.measure(
                    MeasureSpec.makeMeasureSpec(mScreenWidth - 2 * (mRightLayout.getMeasuredWidth() + mRedPointLayout.getMeasuredWidth()), MeasureSpec.EXACTLY)
                    , heightMeasureSpec);
        }
        measureChild(mDividerView, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mLeftLayout.layout(0, mStatusBarHeight, mLeftLayout.getMeasuredWidth(), mLeftLayout.getMeasuredHeight() + mStatusBarHeight);
        mRightLayout.layout(mScreenWidth - mRightLayout.getMeasuredWidth() - mRedPointLayout.getMeasuredWidth(), mStatusBarHeight,
                mScreenWidth - mRedPointLayout.getMeasuredWidth(), mRightLayout.getMeasuredHeight() + mStatusBarHeight);
        mRedPointLayout.layout(mScreenWidth - mRedPointLayout.getMeasuredWidth(), mStatusBarHeight,
                mScreenWidth, mRedPointLayout.getMeasuredHeight() + mStatusBarHeight);
        if (mLeftLayout.getMeasuredWidth() > mRightLayout.getMeasuredWidth() + mRedPointLayout.getMeasuredWidth()) {
            mCenterLayout.layout(mLeftLayout.getMeasuredWidth(), mStatusBarHeight,
                    mScreenWidth - mLeftLayout.getMeasuredWidth(), getMeasuredHeight());
        } else {
            mCenterLayout.layout(mRightLayout.getMeasuredWidth() + mRedPointLayout.getMeasuredWidth(), mStatusBarHeight,
                    mScreenWidth - mRightLayout.getMeasuredWidth() - mRedPointLayout.getMeasuredWidth(), getMeasuredHeight());
        }
        mDividerView.layout(0, getMeasuredHeight() - mDividerView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
    }

    public static int dip2px(int dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private static int getSystemStatusBarHeight() {
        int result = 0;
        Resources res = Resources.getSystem();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * A {@link LinkedList} that holds a list of {@link Action}s.
     */
    @SuppressWarnings("serial")
    public static class ActionList extends LinkedList<Action> {
    }

    /**
     * Definition of an action that could be performed, along with a icon to
     * show.
     */
    public interface Action {
        String getText();

        int getDrawable();

        void performAction(View view);
    }

    public static abstract class ImageAction implements Action {
        private int mDrawable;

        public ImageAction(int drawable) {
            mDrawable = drawable;
        }

        @Override
        public int getDrawable() {
            return mDrawable;
        }

        @Override
        public String getText() {
            return null;
        }
    }

    public static abstract class TextAction implements Action {
        final private String mText;

        public TextAction(String text) {
            mText = text;
        }

        @Override
        public int getDrawable() {
            return 0;
        }

        @Override
        public String getText() {
            return mText;
        }
    }

}
