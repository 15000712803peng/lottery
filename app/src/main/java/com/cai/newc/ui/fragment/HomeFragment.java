package com.cai.newc.ui.fragment;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.cai.newc.R;
import com.cai.newc.adapter.HomeTabAdapter;
import com.cai.newc.base.BaseFragment;
import com.cai.newc.ui.view.PagerSlidingTabStrip;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/10
 */

public class HomeFragment extends BaseFragment{

    @Bind(R.id.tabs)
    PagerSlidingTabStrip homeTabs;
    @Bind(R.id.pager)
    ViewPager homePager;
    HomeTabAdapter tabAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override

    protected void loadData() {
        super.loadData();
        initTabs();
    }

    private void initTabs(){
        DisplayMetrics dm = getResources().getDisplayMetrics();
        homePager.setAdapter(new HomeTabAdapter(getChildFragmentManager()));
        homeTabs.setViewPager(homePager);
        homePager.setCurrentItem(0);
        homeTabs.setDividerColor(Color.TRANSPARENT);
        homeTabs.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 3, dm));
        // 设置Tab Indicator的高度
        homeTabs.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 3, dm));
        // 设置Tab标题文字的大小
        homeTabs.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, dm));
        homeTabs.setTextColor(Color.parseColor("#9EA9B7"));
        homeTabs.setIndicatorColor(Color.parseColor("#030634"));
        homeTabs.setSelectedTextColor(Color.parseColor("#030634"));
        // 取消点击Tab时的背景色
        homeTabs.setTabBackground(0);
        homeTabs.setShouldExpand(true);
    }
}
