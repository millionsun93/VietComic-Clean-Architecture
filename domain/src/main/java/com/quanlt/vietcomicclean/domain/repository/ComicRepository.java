package com.quanlt.vietcomicclean.domain.repository;

import com.quanlt.vietcomicclean.domain.Chapter;
import com.quanlt.vietcomicclean.domain.Comic;

import java.util.List;

import rx.Observable;


public interface ComicRepository {
    Observable<List<Comic>> getComics(int page);

    Observable<Comic> getComic(String comicId);

    Observable<Chapter> getChapter(String comicId, String chapterName);

    Observable<List<Comic>> searchComic(String title);
}
