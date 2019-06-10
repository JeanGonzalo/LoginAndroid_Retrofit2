package com.example.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public RetrofitClient(){

    }

    private static final String url = "https://myjsonclass.000webhostapp.com/";

    private static Retrofit getRetroClient()
    {
        //Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();

        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static APIService getApiService()
    {
        return getRetroClient().create(APIService.class);
    }


}
