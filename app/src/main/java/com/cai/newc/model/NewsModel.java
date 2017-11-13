package com.cai.newc.model;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class NewsModel {


    public final static int TYPE_NES_ONE = 1;
    public final static int TYPE_NES_TWO= 2;

    private int type ;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public NewsModel(int type) {
        this.type = type;
    }

    public NewsModel() {
    }
}
