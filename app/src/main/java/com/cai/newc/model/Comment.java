package com.cai.newc.model;

/**
 * Created by Administrator on 2017/10/17 0017.
 */

public class Comment {

    String comment;
    String createdDate;
    int fetcherId;
    String fetcherScore;
    String id;

    String updatedDate;
    String userId;
    String nickName;
    String headPortraitUrl  ;

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }



    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getFetcherId() {
        return fetcherId;
    }

    public void setFetcherId(int fetcherId) {
        this.fetcherId = fetcherId;
    }

    public String getFetcherScore() {
        return fetcherScore;
    }

    public void setFetcherScore(String fetcherScore) {
        this.fetcherScore = fetcherScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
