package com.droid.nav.mvvmlogin.di;

import android.arch.lifecycle.ViewModelProvider;

import com.droid.nav.mvvmlogin.services.repository.ApiService;
import com.droid.nav.mvvmlogin.viewmodel.ProjectViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */


@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {
    @Singleton @Provides
    ApiService provideGithubService() {
        return new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ProjectViewModelFactory(viewModelSubComponent.build());
    }

}