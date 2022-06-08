package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    //http://113.198.137.183:7998/
    String BASE_URL = "https://ec2-13-209-74-60.ap-northeast-2.compute.amazonaws.com:3000";

    @GET("user/users")
    Call<List<Results>> getuserInfo();
}