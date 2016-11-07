package com.quanlt.vietcomicclean.data.repository;

import com.quanlt.vietcomicclean.data.entity.mapper.ChapterEntityMapper;
import com.quanlt.vietcomicclean.data.entity.mapper.ComicEntityMapper;
import com.quanlt.vietcomicclean.data.entity.mapper.ComicsEntityMapper;
import com.quanlt.vietcomicclean.data.repository.datasource.ComicDataStore;
import com.quanlt.vietcomicclean.data.repository.datasource.ComicDataStoreFactory;
import com.quanlt.vietcomicclean.domain.Chapter;
import com.quanlt.vietcomicclean.domain.Comic;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;


@Singleton
public class ComicDataRepository implements ComicRepository {
    private final ComicDataStoreFactory comicDataStoreFactory;
    private final ComicsEntityMapper comicsEntityMapper;
    private final ComicEntityMapper comicEntityMapper;
    private final ChapterEntityMapper chapterEntityMapper;

    @Inject
    public ComicDataRepository(ComicDataStoreFactory comicDataStoreFactory, ComicsEntityMapper comicsEntityMapper,
                               ComicEntityMapper comicEntityMapper, ChapterEntityMapper chapterEntityMapper) {
        this.comicDataStoreFactory = comicDataStoreFactory;
        this.comicsEntityMapper = comicsEntityMapper;
        this.comicEntityMapper = comicEntityMapper;
        this.chapterEntityMapper = chapterEntityMapper;
    }

    @Override
    public Observable<List<Comic>> getComics(int page) {
        final ComicDataStore comicDataStore = this.comicDataStoreFactory.createCloudDataStore();
        return comicDataStore.getComics(page).map(this.comicsEntityMapper::transform);
    }

    @Override
    public Observable<Comic> getComic(String comicId) {
        final ComicDataStore comicDataStore = this.comicDataStoreFactory.createCloudDataStore();
        return comicDataStore.getComic(comicId).map(this.comicEntityMapper::transform);
    }

    @Override
    public Observable<Chapter> getChapter(String comicId, String chapterName) {
        final ComicDataStore comicDataStore = this.comicDataStoreFactory.createCloudDataStore();
        return comicDataStore.getChapter(comicId, chapterName).map(this.chapterEntityMapper::transform);
    }

    @Override
    public Observable<List<Comic>> searchComic(String title) {
        final ComicDataStore comicDataStore = this.comicDataStoreFactory.createCloudDataStore();
        return comicDataStore.searchComic(title).map(this.comicsEntityMapper::transform);
    }
}
