package com.friendroid.daggermvvmwithretrofit.di;

import com.friendroid.daggermvvmwithretrofit.di.AppModule;
import com.friendroid.daggermvvmwithretrofit.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
