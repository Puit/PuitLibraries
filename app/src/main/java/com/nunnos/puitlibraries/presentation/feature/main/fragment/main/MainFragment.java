package com.nunnos.puitlibraries.presentation.feature.main.fragment.main;

import android.os.Bundle;

import com.nunnos.puitlibraries.R;
import com.nunnos.puitlibraries.base.baseview.BaseFragmentViewModelLiveData;
import com.nunnos.puitlibraries.databinding.FragmentMainBinding;
import com.nunnos.puitlibraries.presentation.feature.main.activity.vm.MainViewModel;

public class MainFragment extends BaseFragmentViewModelLiveData<MainViewModel, FragmentMainBinding> {


    public MainFragment() {
        //Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    //Region Base Methods
    @Override
    protected int layout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void dataBindingViewModel() {
        databinding.setShareviewmodel(shareViewModel);
    }

    @Override
    protected boolean isShareViewModel() {
        return true;
    }
}