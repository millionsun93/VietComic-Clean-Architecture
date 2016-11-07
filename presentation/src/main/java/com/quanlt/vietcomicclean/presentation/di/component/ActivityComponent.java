package com.quanlt.vietcomicclean.presentation.di.component;

import android.app.Activity;

import com.quanlt.vietcomicclean.presentation.di.PerActivity;
import com.quanlt.vietcomicclean.presentation.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}