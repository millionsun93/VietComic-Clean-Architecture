package com.quanlt.vietcomicclean.data.repository.datasource;

import com.quanlt.vietcomicclean.data.entity.ChapterEntity;
import com.quanlt.vietcomicclean.data.entity.ComicEntity;

import java.util.List;

import rx.Observable;


public interface ComicDataStore {
    Observable<List<ComicEntity>> getComics(int page);

    Observable<ComicEntity> getComic(String id);

    Observable<ChapterEntity> getChapter(String id, String chapterTitle);

    Observable<List<ComicEntity>> searchComic(String query);
}
