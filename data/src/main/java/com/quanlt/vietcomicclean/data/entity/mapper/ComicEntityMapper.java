package com.quanlt.vietcomicclean.data.entity.mapper;

import com.quanlt.vietcomicclean.data.entity.ComicEntity;
import com.quanlt.vietcomicclean.domain.Comic;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ComicEntityMapper {
    @Inject
    public ComicEntityMapper() {
    }

    public Comic transform(ComicEntity comicEntity) {
        Comic comic = null;
        if (comicEntity != null) {
            comic = Mapper.transform(comicEntity);
        }
        return comic;
    }
}
