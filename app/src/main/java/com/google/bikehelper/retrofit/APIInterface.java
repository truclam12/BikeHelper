package com.google.bikehelper.retrofit;

import com.google.bikehelper.Register;
import com.google.bikehelper.model.UsersModel;
import com.google.bikehelper.model.UsersRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<UsersModel> performUserLogin(
            @Field("username") String username,
            @Field("password") String password,
            @Field("object") String object
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<UsersRegister> performUserLogin(
            @Field("username") String username,
            @Field("password") String password,
            @Field("fullname") String full_name,
            @Field("phonenumber") String phone_number
    );

}
