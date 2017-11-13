package com.cai.newc.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    protected Bundle mBundle;

    protected BaseActivity mActivity;

    private InputMethodManager mIMM;
    private boolean mNeedHideSoft;  // 隐藏软键盘

    private static final long SHOW_SPACE = 200L;



    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }  else {
            throw new RuntimeException(context.toString() + "must extends BaseActivity!");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = getArguments();
        initBundle(mBundle);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            onBindViewBefore(mRootView);
            ButterKnife.bind(this, mRootView);
            if (savedInstanceState != null) {
                onRestartInstance(savedInstanceState);
            }
            initView(mRootView);
            loadData();
        }
        return mRootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mNeedHideSoft) {
            hideSoftInput();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unSubscribe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        mBundle = null;
    }

    protected void initBundle(Bundle bundle) {

    }

    protected abstract int getLayoutId();

    protected void initView(View rootView) {

    }

    protected void loadData() {

    }

    protected void onBindViewBefore(View rootView) {

    }

    protected void onRestartInstance(Bundle bundle) {

    }


    // rx总线
    private CompositeSubscription compositeSubscription;

    public void addSubscribe(Subscription subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    public void unSubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            compositeSubscription = null;
        }
    }

    /**
     * 显示软键盘,调用该方法后,会在onPause时自动隐藏软键盘
     */
    protected void showSoftInput(final View view) {
        if (view == null) return;
        initImm();
        view.requestFocus();
        mNeedHideSoft = true;
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIMM.showSoftInput(view, InputMethodManager.SHOW_FORCED);
            }
        }, SHOW_SPACE);
    }


    /**
     * 隐藏软键盘
     */
    protected void hideSoftInput() {
        if (getView() != null) {
            initImm();
            mIMM.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    private void initImm() {
        if (mIMM == null) {
            mIMM = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        }
    }

}
