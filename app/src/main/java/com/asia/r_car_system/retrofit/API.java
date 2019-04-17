package com.asia.r_car_system.retrofit;


import com.asia.r_car_system.retrofit.jsons.fine.FineResponse;
import com.asia.r_car_system.retrofit.jsons.login.LoginResponse;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    //login
//    @FormUrlEncoded
    @GET("login.php")
    Call<LoginResponse> userLogin(
            @Query("phone_num") String phone,
            @Query("password") String Password);


    //login
//    @FormUrlEncoded
    @GET("fine.php")
    Call<FineResponse> fine(
            @Query("id") String id);


    //login
//    @FormUrlEncoded
    @GET("car.php")
    Call<ProfileResponse> Profile(
            @Query("id") String id);


}
