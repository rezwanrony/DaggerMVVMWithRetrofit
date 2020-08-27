package com.friendroid.daggermvvmwithretrofit.services;

import com.friendroid.daggermvvmwithretrofit.model.CovidData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService  {

    String BASE_URL = "https://covid19.mathdro.id/";

    @GET("api/")
    Call<CovidData> getCovidData();

}
