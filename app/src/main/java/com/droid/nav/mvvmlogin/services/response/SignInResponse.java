package com.droid.nav.mvvmlogin.services.response;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

public class SignInResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public class Data {

        private String token;

        public String getToken() {
            return token;
        }
    }
}
