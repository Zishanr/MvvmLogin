package com.droid.nav.mvvmlogin.di;

import com.droid.nav.mvvmlogin.viewmodel.LoginViewModel;

import dagger.Subcomponent;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    LoginViewModel loginViewModel();
}

