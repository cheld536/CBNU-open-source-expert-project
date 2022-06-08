package com.example.api;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("Info")
    private String userInfo;

    public Results(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getuserInfo() {
        return userInfo;
    }
}