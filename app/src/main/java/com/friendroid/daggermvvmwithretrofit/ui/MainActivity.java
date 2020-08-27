package com.friendroid.daggermvvmwithretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.friendroid.daggermvvmwithretrofit.R;
import com.friendroid.daggermvvmwithretrofit.databinding.ActivityMainBinding;
import com.friendroid.daggermvvmwithretrofit.model.CovidData;
import com.friendroid.daggermvvmwithretrofit.viewmodel.CovidViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        final CovidViewModel viewModel =
                ViewModelProviders.of(this, viewModelFactory).get(CovidViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(CovidViewModel viewModel) {
        viewModel.getcovidLiveDataObservable().observe(this, covidDataList -> {
            int confirmcases = covidDataList.getConfirmed().getValue();
            int recovercases = covidDataList.getRecovered().getValue();
            int deaths = covidDataList.getDeaths().getValue();
            String updated=covidDataList.getLastUpdate();
            activityMainBinding.tvConfirmCase.setText("Confirmed Cases: "+confirmcases);
            activityMainBinding.tvRecovered.setText("Recovered Cases: "+recovercases);
            activityMainBinding.tvDeath.setText("Total Deaths: "+deaths);
            activityMainBinding.tvConfirmCase.setText("Updated Time: "+updated);
        });
    }
}
