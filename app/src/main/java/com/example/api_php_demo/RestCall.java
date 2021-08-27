package com.example.api_php_demo;

import com.example.api_php_demo.model.AppMenuResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Single;

public interface RestCall {

//    @FormUrlEncoded
//    @POST("login_controller.php")
//    Single<AppMenuResponse> getAppMenu(
//            @Field("user_mobile") String user_mobile,
//            @Field("user_password") String user_password,
//            @Field("checklogin") String checklogin);

    @FormUrlEncoded
    @POST("login_controller.php")
    Call<AppMenuResponse> adddata(@Field("user_id") String user_id,
                                  @Field("user_fullname") String user_fullname,
                                  @Field("user_mobile") String user_mobile,
                                  @Field("user_password") String user_password);
}
