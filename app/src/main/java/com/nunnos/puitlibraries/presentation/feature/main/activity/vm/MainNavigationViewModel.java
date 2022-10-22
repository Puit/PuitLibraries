package com.nunnos.puitlibraries.presentation.feature.main.activity.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nunnos.puitlibraries.presentation.feature.main.MainNavigation;

public class MainNavigationViewModel extends ViewModel {

    protected MutableLiveData<Integer> navigation = new MutableLiveData<>();

    public MutableLiveData<Integer> getNavigation() {
        return navigation;
    }

    public void navigateToMain() {
        navigation.setValue(MainNavigation.MAIN);
    }
}
