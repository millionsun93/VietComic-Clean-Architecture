package com.quanlt.vietcomicclean.presentation;

import android.app.Application;

import com.quanlt.vietcomicclean.BuildConfig;
import com.quanlt.vietcomicclean.presentation.di.component.ApplicationComponent;
import com.quanlt.vietcomicclean.presentation.di.component.DaggerApplicationComponent;
import com.quanlt.vietcomicclean.presentation.di.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;


public class ComicApplication extends Application {
    private ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        if (BuildConfig.DEBUG){
            if (!LeakCanary.isInAnalyzerProcess(this)) {
                LeakCanary.install(this);
            }
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
