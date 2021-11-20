package com.google.bikehelper.model;

import com.google.gson.annotations.SerializedName;

public class UsersRegister {
    @SerializedName("status")
    private String status;
    @SerializedName("username")
    private String username;
    @SerializedName("result_code")
    private int result_code;

    public String getStatus() {
        return status;
    }
    public String getUsername() {
        return username;
    }
    public int getResult_code() {
        return result_code;
    }
}
