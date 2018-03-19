package com.droid.nav.mvvmlogin.services.repository;

import android.database.Observable;

import com.droid.nav.mvvmlogin.services.model.SignIn;
import com.droid.nav.mvvmlogin.services.response.SignInResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

public interface ApiService {

    String BASE_URL = "";

    @POST("auth/signin")
    Call<SignInResponse> signIn(@Body SignIn signIn);
}
