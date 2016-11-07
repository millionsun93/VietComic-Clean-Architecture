package com.quanlt.vietcomicclean.data.entity.mapper;

import com.quanlt.vietcomicclean.data.entity.ComicEntity;
import com.quanlt.vietcomicclean.data.entity.ComicResponse;
import com.quanlt.vietcomicclean.domain.Comic;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ComicsEntityMapper {
    @Inject
    public ComicsEntityMapper() {

    }

    public List<Comic> transform(List<ComicEntity> comicEntities) {
        List<Comic> comics = null;
        if (comicEntities != null && !comicEntities.isEmpty()) {
            comics = new ArrayList<>();
            for (ComicEntity entity : comicEntities) {
                comics.add(Mapper.transform(entity));
            }
        }
        return comics;
    }
}
