package com.cai.newc.net;



import com.cai.newc.model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;


public interface ApiService {

    @GET("/api/pub/course/category")
    Call<List<Comment>> category();

}
