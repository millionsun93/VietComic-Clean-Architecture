package com.quanlt.vietcomicclean.domain.interactor;

import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;

import javax.inject.Inject;

import rx.Observable;


public class GetChapter extends UseCase {
    private final String comicId;
    private final String chapterName;
    private final ComicRepository comicRepository;

    @Inject
    public GetChapter(String comicId, String chapterName, ComicRepository comicRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.comicId = comicId;
        this.chapterName = chapterName;
        this.comicRepository = comicRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return comicRepository.getChapter(comicId, chapterName);
    }
}
