package com.quanlt.vietcomicclean.domain.interactor;

import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;

import rx.Observable;


public class GetComicDetail extends UseCase {

    private final String comicId;
    private final ComicRepository comicRepository;

    public GetComicDetail(String comicId, ComicRepository comicRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.comicId = comicId;
        this.comicRepository = comicRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return comicRepository.getComic(comicId);
    }
}
