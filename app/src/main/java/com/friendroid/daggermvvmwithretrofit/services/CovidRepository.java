package com.friendroid.daggermvvmwithretrofit.services;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.friendroid.daggermvvmwithretrofit.model.CovidData;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class CovidRepository {

    private ApiService apiService;
//    private static UserRepository userRepository;

    @Inject
    CovidRepository(ApiService apiService) {
        this.apiService = apiService;
    }

//    public static UserRepository getInstance() {
//        if(userRepository == null) {
//            userRepository = new UserRepository();
//        }
//        return new UserRepository();
//    }

    public LiveData<CovidData> getUserDetailList() {
        final MutableLiveData<CovidData> liveData = new MutableLiveData<>();

        apiService.getCovidData().enqueue(new Callback<CovidData>() {
            @Override
            public void onResponse(Call<CovidData> call, Response<CovidData> response) {
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CovidData> call, Throwable t) {
                Log.d("Log", t.getMessage());
            }
        });

        return liveData;
    }

}
