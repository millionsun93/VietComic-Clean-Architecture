package com.quanlt.vietcomicclean.presentation.di.module;

import android.app.Application;
import android.content.Context;

import com.quanlt.vietcomicclean.data.repository.ComicDataRepository;
import com.quanlt.vietcomicclean.presentation.ComicApplication;
import com.quanlt.vietcomicclean.presentation.UIThread;
import com.quanlt.vietcomicclean.data.executor.JobExecutor;
import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    ComicRepository provideComicRepository(ComicDataRepository comicDataRepository) {
        return comicDataRepository;
    }
}
