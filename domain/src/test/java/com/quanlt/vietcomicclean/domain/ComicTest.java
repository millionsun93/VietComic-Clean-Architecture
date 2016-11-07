package com.quanlt.vietcomicclean.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ComicTest {
    private static final String FAKE_COMIC_ID = "123456";
    private Comic comic;

    @Before
    public void setUp() throws Exception {
        comic = new Comic(FAKE_COMIC_ID);
    }

    @Test
    public void testConstructor() {
        String comicId = comic.getId();
        assertThat(comicId, is(comic.getId()));
    }
}
