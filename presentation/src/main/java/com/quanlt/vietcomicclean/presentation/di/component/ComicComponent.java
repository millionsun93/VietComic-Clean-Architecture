package com.quanlt.vietcomicclean.presentation.di.component;

import com.quanlt.vietcomicclean.presentation.di.PerActivity;
import com.quanlt.vietcomicclean.presentation.di.module.ActivityModule;
import com.quanlt.vietcomicclean.presentation.di.module.ApplicationModule;
import com.quanlt.vietcomicclean.presentation.di.module.ComicModule;
import com.quanlt.vietcomicclean.presentation.view.fragment.ComicDetailFragment;
import com.quanlt.vietcomicclean.presentation.view.fragment.ComicListFragment;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ComicModule.class})
public interface ComicComponent extends ActivityComponent {
    void inject(ComicListFragment fragment);
    void inject(ComicDetailFragment comicDetailFragment);
}
