package com.quanlt.vietcomicclean.data.entity.mapper;

import com.quanlt.vietcomicclean.data.ApplicationTestCase;
import com.quanlt.vietcomicclean.data.entity.ChapterEntity;
import com.quanlt.vietcomicclean.data.entity.ComicEntity;
import com.quanlt.vietcomicclean.data.entity.ComicResponse;
import com.quanlt.vietcomicclean.data.entity.mapper.ComicEntityMapper;
import com.quanlt.vietcomicclean.domain.Comic;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ComicEntityMapperTest extends ApplicationTestCase {
    private ComicEntityMapper comicEntityMapper;
    private static final String FAKE_COMIC_ID = "123456";
    private static final String FAKE_COMIC_TITLE = "Batman";
    private static final String FAKE_COMIC_STATUS = "Completed";
    private static final String FAKE_COMIC_DESCRIPTION = " Quick brown fox jumps over the lazy dog";
    private static final String FAKE_COMIC_LATEST_CHAPTER = "Chapter 9";
    private static final String FAKE_COMIC_THUMBNAIL = "http://i.imgur.com/wQzBdr.jpg";
    private static final List<String> FAKE_COMIC_AUTHORS = Arrays.asList(new String[]{"Acient One", "QuanLT", "NamNQ", "ThuyPTT"});
    private static final List<String> FAKE_COMIC_CATEGORIES = Arrays.asList(new String[]{"Action", "Fantasy", "Thriller"});
    private static final List<ChapterEntity> FAKE_COMIC_CHAPTERS
            = Arrays.asList(new ChapterEntity[]{new ChapterEntity("Chaper 1"), new ChapterEntity("Chaper 2")});
    private static final List<ChapterEntity> FAKE_COMIC_CHAPTERS_NULL = null;
    private static final Date FAKE_UPDATE_TIME = Calendar.getInstance().getTime();

    @Before
    public void setUp() throws Exception {
        comicEntityMapper = new ComicEntityMapper();
    }

    @Test
    public void testTransformComicEntity() throws Exception {
        ComicEntity comicEntity = createFakeComicEntity();
        Comic comic = comicEntityMapper.transform(comicEntity);
        assertEquals(FAKE_COMIC_ID, comic.getId());
        assertEquals(FAKE_UPDATE_TIME, comic.getUpdateTime());
    }

    private ComicResponse<ComicEntity> createFakeComicResponse() {
        ComicResponse<ComicEntity> comicResponse = new ComicResponse<>();
        comicResponse.setData(createFakeComicEntity());
        return comicResponse;
    }

    private ComicEntity createFakeComicEntity() {
        ComicEntity entity = new ComicEntity();
        entity.setTitle(FAKE_COMIC_TITLE);
        entity.setId(FAKE_COMIC_ID);
        entity.setStatus(FAKE_COMIC_STATUS);
        entity.setDescription(FAKE_COMIC_DESCRIPTION);
        entity.setThumbnail(FAKE_COMIC_THUMBNAIL);
        entity.setLastestChapter(FAKE_COMIC_LATEST_CHAPTER);
        entity.setUpdateTime(FAKE_UPDATE_TIME);
        entity.setCategories(FAKE_COMIC_CATEGORIES);
        entity.setChapters(FAKE_COMIC_CHAPTERS);
        entity.setAuthors(FAKE_COMIC_AUTHORS);
        return entity;
    }

}
