package com.cai.newc.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.cai.newc.msg.SafeSender;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/10 0010.
 */

public abstract  class BaseActivity extends FragmentActivity implements SafeSender.OnMessageReceiver{

    public abstract int layout();
    public abstract  void loadData();
    public abstract  void initViews();
    protected SafeSender safeSender;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        ButterKnife.bind(this);
        safeSender = new SafeSender(this);
        loadData();
        initViews();
    }

    protected SafeSender getSafeSender() {
        return safeSender;
    }

}

