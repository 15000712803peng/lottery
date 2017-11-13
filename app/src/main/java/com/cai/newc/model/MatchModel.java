package com.cai.newc.model;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class MatchModel {
    public final static int TYPE_DATE = 1;
    public final static int TYPE_MATCH_ING = 2;
    public final static int TYPE_MATCH_TO= 3;
    public final static int TYPE_MATCH_DONE= 4;
    public MatchModel(){

    }

    public MatchModel(int type){
        this.type = type;
    }
    String date;
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
