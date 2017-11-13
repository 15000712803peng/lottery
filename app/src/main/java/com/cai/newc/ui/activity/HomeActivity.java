package com.cai.newc.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cai.newc.R;
import com.cai.newc.base.BaseActivity;
import com.cai.newc.data.MyTab;
import com.cai.newc.ui.view.MyTabHost;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/11 0011.
 */

public class HomeActivity extends BaseActivity{
    @Bind(R.id.tab_host)
    MyTabHost homeTabs;

    @Override
    public void loadData() {

    }

    @Override
    public void initViews() {
        initTabHost();
    }

    @Override
    public int layout() {
        return R.layout.activity_home;
    }

    @Override
    public void onMessage(Message msg) {

    }

    private void initTabHost() {
        homeTabs.setup(this, getSupportFragmentManager(), R.id.real_content_frame);
        if (android.os.Build.VERSION.SDK_INT > 10) {
            homeTabs.getTabWidget().setShowDividers(0);
        }
        MyTab[] tabs = MyTab.values();
        final int size = tabs.length;
        for (int i = 0; i < size; i++) {
            MyTab mainTab = tabs[i];
            TabHost.TabSpec tab = homeTabs.newTabSpec(getString(mainTab.getResName()));
            View indicator = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.tab_indicator, null);
            ImageView tabIcon = (ImageView) indicator.findViewById(R.id.tab_image);
            TextView title = (TextView) indicator.findViewById(R.id.tab_text);
//            Drawable drawable = this.getResources().getDrawable(
//                    mainTab.getResIcon());
            tabIcon.setImageResource(mainTab.getResIcon());
            title.setText(getString(mainTab.getResName()));
            tab.setIndicator(indicator);
            homeTabs.addTab(tab, mainTab.getClz(), null);
        }
    }
}
