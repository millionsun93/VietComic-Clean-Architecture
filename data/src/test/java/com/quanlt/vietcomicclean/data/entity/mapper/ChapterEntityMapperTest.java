package com.quanlt.vietcomicclean.data.entity.mapper;

import com.quanlt.vietcomicclean.data.ApplicationTestCase;
import com.quanlt.vietcomicclean.data.entity.ChapterEntity;
import com.quanlt.vietcomicclean.data.entity.ComicResponse;
import com.quanlt.vietcomicclean.domain.Chapter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


public class ChapterEntityMapperTest extends ApplicationTestCase {
    private ChapterEntityMapper chapterEntityMapper;
    private static final String FAKE_CHAPTER_TITLE = "chapter 1";
    private static final List<String> FAKE_CHAPTER_URLS = Arrays.asList(new String[]{"url1", "url2", "url3"});

    @Before
    public void setUp() throws Exception {
        chapterEntityMapper = new ChapterEntityMapper();
    }

    @Test
    public void testTransformChapterEntity() throws Exception {
        ChapterEntity chapterEntity = createFakeChapterEntity();
        Chapter chapter = chapterEntityMapper.transform(chapterEntity);
        assertThat(chapter.getTitle(), is(FAKE_CHAPTER_TITLE));
        assertEquals(FAKE_CHAPTER_URLS, chapter.getUrls());
    }

    private ChapterEntity createFakeChapterEntity() {
        ChapterEntity chapterEntity = new ChapterEntity();
        chapterEntity.setTitle(FAKE_CHAPTER_TITLE);
        chapterEntity.setUrls(FAKE_CHAPTER_URLS);
        return chapterEntity;
    }
}
