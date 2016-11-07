package com.quanlt.vietcomicclean.presentation.di.component;

import android.content.Context;

import com.quanlt.vietcomicclean.data.net.ComicApiService;
import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;
import com.quanlt.vietcomicclean.presentation.di.module.ApplicationModule;
import com.quanlt.vietcomicclean.presentation.di.module.NetModule;
import com.quanlt.vietcomicclean.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    ComicRepository comicRepository();

    Retrofit retrofit();

    ComicApiService comicApiService();


}
