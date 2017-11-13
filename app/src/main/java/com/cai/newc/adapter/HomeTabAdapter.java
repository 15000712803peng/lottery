package com.cai.newc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.cai.newc.ui.fragment.HomeOneTabFragment;

public class HomeTabAdapter extends FragmentPagerAdapter{

    String[] titles = new String[]{"全部","进行中","赛果","赛程","关注",};


    public HomeTabAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        HomeOneTabFragment fragment = new HomeOneTabFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
