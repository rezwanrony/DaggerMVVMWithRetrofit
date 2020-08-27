package com.friendroid.daggermvvmwithretrofit.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.friendroid.daggermvvmwithretrofit.di.ViewModelKey;
import com.friendroid.daggermvvmwithretrofit.viewmodel.CovidViewModel;
import com.friendroid.daggermvvmwithretrofit.viewmodel.CovidViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CovidViewModel.class)
    abstract ViewModel bindCovidViewModel(CovidViewModel covidViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(CovidViewModelFactory factory);
}