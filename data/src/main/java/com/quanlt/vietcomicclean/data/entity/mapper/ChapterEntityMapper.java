package com.quanlt.vietcomicclean.data.entity.mapper;

import com.quanlt.vietcomicclean.data.entity.ChapterEntity;
import com.quanlt.vietcomicclean.data.entity.ComicResponse;
import com.quanlt.vietcomicclean.domain.Chapter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ChapterEntityMapper {
    @Inject
    public ChapterEntityMapper() {
    }

    public Chapter transform(ChapterEntity chapterEntity) {
        Chapter chapter = null;
        if (chapterEntity != null) {
            chapter = Mapper.transform(chapterEntity);
        }
        return chapter;
    }
}
