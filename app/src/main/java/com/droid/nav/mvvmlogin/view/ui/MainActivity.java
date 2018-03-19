package com.droid.nav.mvvmlogin.view.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.droid.nav.mvvmlogin.R;
import com.droid.nav.mvvmlogin.services.model.SignIn;
import com.droid.nav.mvvmlogin.viewmodel.LoginViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MainActivity extends AppCompatActivity implements LifecycleOwner ,HasActivityInjector{

    private static final String TAG = MainActivity.class.getName();
    private LoginViewModel viewModel;
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewModel =
                ViewModelProviders.of(this,viewModelFactory).get(LoginViewModel.class);


        observeViewModel(viewModel);
        viewModel.login(new SignIn("",""));
    }

    private void observeViewModel(LoginViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getSignInLiveData().observe(this, projects -> {
            if (projects != null) {

                Log.e(TAG,"loggedin");
            }
        });
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


//    @Override
//    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return null;
//    }
}
