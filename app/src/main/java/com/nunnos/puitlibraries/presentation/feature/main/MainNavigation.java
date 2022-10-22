package com.nunnos.puitlibraries.presentation.feature.main;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
        MainNavigation.MAIN
})
@Retention(RetentionPolicy.SOURCE)
public @interface MainNavigation {
    int MAIN = 0;
}
