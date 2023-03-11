package com.kartik.evidya.retrofit;

import com.example.chatapp.model.UserResultEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("login")
    @Headers("Accept: application/json")
    @FormUrlEncoded
    Call<UserResultEntity> appLogin(@Field("email") String email,
                                    @Field("password") String password);
}
