package com.friendroid.daggermvvmwithretrofit.di;

import com.friendroid.daggermvvmwithretrofit.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
