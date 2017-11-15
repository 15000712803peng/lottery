package com.cai.newc.data;


import com.cai.newc.R;
import com.cai.newc.base.BaseFragment;
import com.cai.newc.ui.fragment.AnalyzeFragment;
import com.cai.newc.ui.fragment.DiscFragment;
import com.cai.newc.ui.fragment.HomeFragment;

public enum  MyTab {

    HOME(1, R.string.home, R.drawable.tab_home,
            HomeFragment.class),

    DISCOVER(2, R.string.discover, R.drawable.tab_disc,
            DiscFragment.class),

    ANALYSIS(3, R.string.analysis, R.drawable.tab_analysis,
            AnalyzeFragment.class),

    MINE(4, R.string.mine, R.drawable.tab_mine,
            BaseFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MyTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
