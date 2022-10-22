package com.nunnos.puitlibraries.presentation.feature.main;

import static com.nunnos.puitlibraries.presentation.feature.main.MainNavigation.MAIN;

import androidx.annotation.NonNull;

import com.nunnos.puitlibraries.presentation.feature.main.activity.MainActivity;
import com.nunnos.puitlibraries.presentation.feature.main.activity.vm.MainViewModel;
import com.nunnos.puitlibraries.presentation.feature.main.fragment.main.MainFragment;

public class MainNavigationManager {
    private MainNavigationManager() {
        // not required
    }

    public static void goTo(@NonNull MainActivity activity, @MainNavigation Integer navigation, MainViewModel viewModel) {
        switch (navigation) {
            case MAIN:
                navigateToMain(activity);
                break;
            default:
                throw new IllegalStateException("ContactInfoNavigationManager error, navigation has not been implementad");
        }
    }

    private static void navigateToMain(MainActivity activity) {
        activity.overrideSlidingUpTransition(MainFragment.newInstance());
    }


}
