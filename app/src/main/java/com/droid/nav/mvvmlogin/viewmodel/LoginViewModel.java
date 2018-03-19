package com.droid.nav.mvvmlogin.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.droid.nav.mvvmlogin.LoginApplication;
import com.droid.nav.mvvmlogin.services.model.SignIn;
import com.droid.nav.mvvmlogin.services.repository.ProjectRepository;
import com.droid.nav.mvvmlogin.services.response.SignInResponse;

import javax.inject.Inject;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<SignInResponse> signInLiveData;

    @Inject
    ProjectRepository projectRepository;

    @Inject
    public LoginViewModel(@NonNull LoginApplication application,@NonNull ProjectRepository projectRepository) {
        super(application);

//        signInLiveData = new MutableLiveData<>();

        signInLiveData = projectRepository.initSignIn();
    }

    public void login(SignIn signIn) {

        projectRepository.login(this.signInLiveData,signIn);

    }

    public LiveData<SignInResponse> getSignInLiveData() {
        return signInLiveData;
    }
}
