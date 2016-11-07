package com.quanlt.vietcomicclean.data.entity.mapper;

import com.quanlt.vietcomicclean.data.entity.ChapterEntity;
import com.quanlt.vietcomicclean.data.entity.ComicEntity;
import com.quanlt.vietcomicclean.domain.Chapter;
import com.quanlt.vietcomicclean.domain.Comic;

import java.util.ArrayList;
import java.util.List;


public final class Mapper {

    private Mapper() {
    }

    public static Comic transform(ComicEntity comicEntity) {
        Comic comic = null;
        if (comicEntity != null) {
            comic = new Comic();
            comic.setId(comicEntity.getId());
            comic.setTitle(comicEntity.getTitle());
            comic.setStatus(comicEntity.getStatus());
            comic.setDescription(comicEntity.getDescription());
            comic.setThumbnail(comicEntity.getThumbnail());
            comic.setAuthors(comicEntity.getAuthors());
            comic.setCategories(comicEntity.getCategories());
            comic.setLastestChapter(comicEntity.getLastestChapter());
            comic.setUpdateTime(comicEntity.getUpdateTime());
            comic.setViewers(comicEntity.getViewers());
            List<ChapterEntity> chapterEntities = comicEntity.getChapters();
            List<Chapter> chapters = new ArrayList<>();
            if (chapterEntities != null && !chapterEntities.isEmpty()) {
                for (ChapterEntity entity : chapterEntities) {
                    chapters.add(transform(entity));
                }
            }
            comic.setChapters(chapters);
        }
        return comic;
    }

    public static Chapter transform(ChapterEntity chapterEntity) {
        Chapter chapter = null;
        if (chapterEntity != null) {
            chapter = new Chapter();
            chapter.setTitle(chapterEntity.getTitle());
            chapter.setUrls(chapterEntity.getUrls());
        }
        return chapter;
    }
}
