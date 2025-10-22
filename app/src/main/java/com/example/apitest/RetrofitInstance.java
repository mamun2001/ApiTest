package com.example.apitest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BaseURL= "https://jsonplaceholder.typicode.com";
    public static RetrofitInstance instance;
    ApiInterface apiInterface;

    RetrofitInstance(){
        Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

         apiInterface = retrofit.create(ApiInterface.class);
        }
    public static RetrofitInstance getInstance() {
        if(instance==null){
            instance=new RetrofitInstance();
        }
        return instance;
    }
}


