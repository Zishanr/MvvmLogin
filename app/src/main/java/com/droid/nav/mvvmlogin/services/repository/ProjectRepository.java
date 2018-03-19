package com.droid.nav.mvvmlogin.services.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.droid.nav.mvvmlogin.services.model.SignIn;
import com.droid.nav.mvvmlogin.services.response.SignInResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

@Singleton
public class ProjectRepository {

    private ApiService apiService;


    @Inject
    public ProjectRepository(ApiService apiService) {

        this.apiService = apiService;

    }

    public MutableLiveData<SignInResponse> initSignIn() {
        final MutableLiveData<SignInResponse> data = new MutableLiveData<>();
        return data;
    }


    public LiveData<SignInResponse> login(final MutableLiveData<SignInResponse> data, SignIn signIn) {

        if (signIn == null)
            return data;

        apiService.signIn(signIn).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {

                data.setValue(response.body());

            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {

            }
        });

        return data;
    }

}
