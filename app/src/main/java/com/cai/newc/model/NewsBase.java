package com.cai.newc.model;

/**
 * Created by Administrator on 2017/11/15 0015.
 */

public class NewsBase {
    public static final int TYPE_TXT= 1;
    public static final int TYPE_IMAGE= 2;
    protected int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
