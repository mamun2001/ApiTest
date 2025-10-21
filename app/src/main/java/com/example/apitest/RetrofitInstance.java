package com.example.apitest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BaseURL="https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit;
    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
        }

    public  static ApiInterface getApiInterface(){
        return RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
    }
}


