package com.kartik.evidya.retrofit;

import static com.example.chatapp.app.ChatApplicationApp.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;




    public static Retrofit getApiClient()
    {
        if (retrofit == null)
        {

            retrofit = new Retrofit.Builder()

                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
