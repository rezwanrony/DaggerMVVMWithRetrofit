package com.friendroid.daggermvvmwithretrofit.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.friendroid.daggermvvmwithretrofit.model.CovidData;
import com.friendroid.daggermvvmwithretrofit.services.CovidRepository;

import javax.inject.Inject;

public class CovidViewModel extends ViewModel {

    private final LiveData<CovidData> covidLiveDataObservable;

    @Inject
    public CovidViewModel(@NonNull CovidRepository covidRepository) {
        covidLiveDataObservable = covidRepository.getUserDetailList();
    }


    public LiveData<CovidData> getcovidLiveDataObservable() {
        return covidLiveDataObservable;
    }
}
