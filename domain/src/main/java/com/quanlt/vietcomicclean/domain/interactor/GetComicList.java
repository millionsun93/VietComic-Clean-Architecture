package com.quanlt.vietcomicclean.domain.interactor;

import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by quanlt on 05/11/2016.
 */

public class GetComicList extends UseCase {
    private final ComicRepository comicRepository;
    private int page;

    @Inject
    public GetComicList(int pageComicRepository, ComicRepository comicRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.comicRepository = comicRepository;
        this.page = pageComicRepository;
    }

    public GetComicList setPage(int page) {
        this.page = page;
        return this;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return comicRepository.getComics(page);
    }
}
