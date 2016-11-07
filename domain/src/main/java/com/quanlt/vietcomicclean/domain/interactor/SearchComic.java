package com.quanlt.vietcomicclean.domain.interactor;

import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;

import javax.inject.Inject;

import rx.Observable;

public class SearchComic extends UseCase {
    private final ComicRepository comicRepository;
    private final String title;

    @Inject
    public SearchComic(String title, ComicRepository comicRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.comicRepository = comicRepository;
        this.title = title;
    }


    @Override
    protected Observable buildUseCaseObservable() {
        return comicRepository.searchComic(title);
    }
}
