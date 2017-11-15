package com.cai.newc.model;

/**
 * Created by Administrator on 2017/11/15 0015.
 */

public class ImageNews extends NewsBase{
    public ImageNews(){
        setType(NewsBase.TYPE_IMAGE);
    }
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
