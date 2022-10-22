package com.nunnos.puitlibraries.presentation.feature.main.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nunnos.puitlibraries.R;
import com.nunnos.puitlibraries.base.baseview.BaseActivityViewModelLiveData;
import com.nunnos.puitlibraries.databinding.ActivityMainBinding;

import com.nunnos.puitlibraries.presentation.feature.main.MainNavigationManager;
import com.nunnos.puitlibraries.presentation.feature.main.activity.vm.MainViewModel;
import com.nunnos.puitlibraries.presentation.feature.main.fragment.main.MainFragment;

public class MainActivity extends BaseActivityViewModelLiveData<MainViewModel, ActivityMainBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myOncreate();
    }

    private void myOncreate() {

        setView();
        initObservers();
        redirectTo();
    }

    private void setView() {

    }

    private void initObservers() {
        viewModel.getNavigation().observe(this, navigation -> {
            MainNavigationManager.goTo(this, navigation, viewModel);
        });
    }

    private Context getFragmentContext() {
        return dataBinding.activityFragmentContainer.getContext();
    }

    private void redirectTo() {
        viewModel.navigateToMain();
    }


    /*******************************************
     * IMPLEMENTATION BASE CLASS
     * *****************************************/
    @Override
    protected int layout() {
        return R.layout.activity_main;
    }

    @Override
    protected void dataBindingViewModel() {
        viewModel = new MainViewModel();
        dataBinding.setShareviewmodel(viewModel);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.activity_fragment_container);
        if (fragment instanceof MainFragment) {
            this.finishAndRemoveTask(); //TODO: matarà las notificaciones?
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected Class<MainViewModel> getClassViewModel() {
        return MainViewModel.class;
    }
}