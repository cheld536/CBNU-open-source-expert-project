package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "";

    @GET("user/users")
    Call<List<Results>> getuserInfo();
}
