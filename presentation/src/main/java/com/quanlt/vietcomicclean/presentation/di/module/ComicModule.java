package com.quanlt.vietcomicclean.presentation.di.module;

import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;
import com.quanlt.vietcomicclean.domain.interactor.GetComicDetail;
import com.quanlt.vietcomicclean.domain.interactor.GetComicList;
import com.quanlt.vietcomicclean.domain.interactor.UseCase;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;
import com.quanlt.vietcomicclean.presentation.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;


@Module
public class ComicModule {
    private String comicId = "111111";
    private Integer page = 1;

    public ComicModule() {
    }

    public ComicModule(String comicId) {
        this.comicId = comicId;
    }

    public ComicModule(Integer page) {
        this.page = page;
    }

    @Provides
    @PerActivity
    @Named("comicList")
    UseCase provideGetComicListUseCase(ComicRepository comicRepository, ThreadExecutor threadExecutor,
                                       PostExecutionThread postExecutionThread) {
        return new GetComicList(page, comicRepository, threadExecutor, postExecutionThread);
    }

    @Provides
    @PerActivity
    @Named("comicDetail")
    UseCase provideGetComicDetailUseCase(ComicRepository comicRepository, GetComicDetail getComicDetail,
                                         ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetComicDetail(comicId, comicRepository, threadExecutor, postExecutionThread);
    }
}
