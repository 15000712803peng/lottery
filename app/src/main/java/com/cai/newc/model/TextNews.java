package com.cai.newc.model;

/**
 * Created by Administrator on 2017/11/15 0015.
 */

public class TextNews extends NewsBase{
    private String content;
    public TextNews(){
        setType(NewsBase.TYPE_TXT);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
