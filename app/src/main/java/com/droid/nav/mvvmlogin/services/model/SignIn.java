package com.droid.nav.mvvmlogin.services.model;

import android.databinding.Bindable;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

public class SignIn {

    public SignIn(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    private String deviceToken;
    private String loginId;
    private String password;


}
