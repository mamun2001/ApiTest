package com.example.apitest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/photos")
    Call<DataModel> getPhotos();
}
