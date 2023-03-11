package com.kartik.evidya.repository;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.chatapp.model.UserResultEntity;
import com.example.chatapp.retrofit.ApiClient;
import com.example.chatapp.retrofit.ApiServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompRepository {
    private static CompRepository sInstance;


    public static CompRepository getInstance() {
        if (sInstance == null) {
            sInstance = new CompRepository();
        }
        return sInstance;
    }


    //logindetails
    public LiveData<UserResultEntity> getLoginDetails(String email, String password) {
        LiveData<UserResultEntity> data = new MutableLiveData<>();

        try {
            ApiServices apiServices = ApiClient.getApiClient().create(ApiServices.class);
            Call<UserResultEntity> call = apiServices.appLogin(email, password);

            call.enqueue(new Callback<UserResultEntity>() {
                @Override
                public void onResponse(Call<UserResultEntity> call, Response<UserResultEntity> response) {
                    try {

                        if (response.raw().isSuccessful()) {
                            ((MutableLiveData<UserResultEntity>) data).setValue(response.body());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<UserResultEntity> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}