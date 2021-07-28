package com.example.api_php_demo;

import com.example.api_php_demo.model.AppMenuResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestCall {

    @FormUrlEncoded
    @POST("login_controller.php")
    Call<AppMenuResponse> getAppMenu(
            @Field("user_mobile") String user_mobile,
            @Field("user_password") String user_password,
            @Field("checklogin") String checklogin);
}
