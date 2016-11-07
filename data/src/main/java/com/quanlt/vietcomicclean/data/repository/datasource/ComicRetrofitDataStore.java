package com.quanlt.vietcomicclean.data.repository.datasource;

import com.quanlt.vietcomicclean.data.entity.ChapterEntity;
import com.quanlt.vietcomicclean.data.entity.ComicEntity;
import com.quanlt.vietcomicclean.data.exception.ComicNotFoundException;
import com.quanlt.vietcomicclean.data.net.ComicApiService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.exceptions.Exceptions;

/**

 */

public class ComicRetrofitDataStore implements ComicDataStore {
    private ComicApiService comicApiService;

    @Inject
    public ComicRetrofitDataStore(ComicApiService comicApiService) {
        this.comicApiService = comicApiService;
    }


    @Override
    public Observable<List<ComicEntity>> getComics(int page) {
        return comicApiService.getComics(page).map(listComicResponse -> {
            if (listComicResponse.getData() != null) {
                return listComicResponse.getData();
            } else {
                if (listComicResponse.getDescription() != null) {
                    ComicNotFoundException exception = new ComicNotFoundException(listComicResponse.getDescription());
                    throw Exceptions.propagate(exception);
                } else {
                    throw Exceptions.propagate(new Exception("Unknow error"));
                }
            }

        });
    }

    @Override
    public Observable<ComicEntity> getComic(String id) {
        return comicApiService.getComicDetail(id).map(comicEntityComicResponse -> comicEntityComicResponse.getData());
    }

    @Override
    public Observable<ChapterEntity> getChapter(String id, String chapterTitle) {
        return comicApiService.getChapter(id, chapterTitle).map(chapterEntityComicResponse -> chapterEntityComicResponse.getData());
    }

    @Override
    public Observable<List<ComicEntity>> searchComic(String query) {
        return comicApiService.searchComic(query).map(listComicResponse -> listComicResponse.getData());
    }
}
