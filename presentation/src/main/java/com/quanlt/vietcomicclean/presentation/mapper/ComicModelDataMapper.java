package com.quanlt.vietcomicclean.presentation.mapper;

import com.quanlt.vietcomicclean.domain.Chapter;
import com.quanlt.vietcomicclean.domain.Comic;
import com.quanlt.vietcomicclean.presentation.di.PerActivity;
import com.quanlt.vietcomicclean.presentation.model.ChapterModel;
import com.quanlt.vietcomicclean.presentation.model.ComicModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

@PerActivity
public class ComicModelDataMapper {
    @Inject
    public ComicModelDataMapper() {
    }

    public ComicModel transform(Comic comic) {
        if (comic == null) {
            throw new IllegalArgumentException("Chapter can not be null");
        }
        ComicModel comicModel = new ComicModel();
        comicModel.setTitle(comic.getTitle());
        comicModel.setUpdateTime(comic.getUpdateTime());
        comicModel.setStatus(comic.getStatus());
        comicModel.setDescription(comic.getDescription());
        comicModel.setAuthors(comic.getAuthors());
        comicModel.setCategories(comic.getCategories());
        comicModel.setThumbnail(comic.getThumbnail());
        if (comic.getChapters() != null) {
            List<ChapterModel> chapterModelList = new ArrayList<>();
            for (Chapter chapter : comic.getChapters()) {
                chapterModelList.add(transform(chapter));
            }
            comicModel.setChapters(chapterModelList);
        }
        comicModel.setLatestChapter(comic.getLatestChapter());
        return comicModel;
    }

    public Collection<ComicModel> transform(Collection<Comic> comics) {
        Collection<ComicModel> comicModelCollection;
        if (comics != null && !comics.isEmpty()) {
            comicModelCollection = new ArrayList<>();
            for (Comic comic : comics) {
                comicModelCollection.add(transform(comic));
            }
        } else {
            comicModelCollection = Collections.emptyList();
        }
        return comicModelCollection;

    }

    public ChapterModel transform(Chapter chapter) {
        if (chapter == null) {
            throw new IllegalArgumentException("Chapter can not be null");
        }
        ChapterModel chapterModel = new ChapterModel();
        chapterModel.setTitle(chapter.getTitle());
        chapterModel.setUrls(chapter.getUrls());
        return chapterModel;
    }
}
