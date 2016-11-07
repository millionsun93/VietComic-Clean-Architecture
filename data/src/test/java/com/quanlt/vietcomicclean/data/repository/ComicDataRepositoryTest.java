package com.quanlt.vietcomicclean.data.repository;

import com.quanlt.vietcomicclean.data.ApplicationTestCase;
import com.quanlt.vietcomicclean.data.entity.ComicEntity;
import com.quanlt.vietcomicclean.data.entity.mapper.ChapterEntityMapper;
import com.quanlt.vietcomicclean.data.entity.mapper.ComicEntityMapper;
import com.quanlt.vietcomicclean.data.entity.mapper.ComicsEntityMapper;
import com.quanlt.vietcomicclean.data.repository.datasource.ComicDataStore;
import com.quanlt.vietcomicclean.data.repository.datasource.ComicDataStoreFactory;
import com.quanlt.vietcomicclean.domain.Comic;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


public class ComicDataRepositoryTest extends ApplicationTestCase {
    private static final String FAKE_COMIC_ID = "123456";

    private ComicDataRepository comicDataRepository;

    @Mock
    private ComicDataStoreFactory mockComicDataStoreFactory;
    @Mock
    private ComicDataStore mockComicDataStore;
    @Mock
    private ComicEntityMapper mockComicEntityMapper;
    @Mock
    private ComicsEntityMapper mockComicsEntityMapper;
    @Mock
    private ChapterEntityMapper mockChapterEntityMapper;
    @Mock
    private ComicEntity mockComicEntity;
    @Mock
    private Comic comic;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        comicDataRepository = new ComicDataRepository(mockComicDataStoreFactory, mockComicsEntityMapper
                , mockComicEntityMapper, mockChapterEntityMapper);
        given(mockComicDataStoreFactory.createCloudDataStore()).willReturn(mockComicDataStore);
    }

    @Test
    public void testGetComicsHappyCase() throws Exception {
        int page = anyInt();
        List<ComicEntity> comicEntities = Arrays.asList(new ComicEntity[]{new ComicEntity()});

        given(mockComicDataStore.getComics(page)).willReturn(Observable.just(comicEntities));

        comicDataRepository.getComics(page);

        verify(mockComicDataStoreFactory).createCloudDataStore();
        verify(mockComicDataStore).getComics(page);
    }

    @Test
    public void testGetComicHappyCase() throws Exception {
        ComicEntity comicEntity = new ComicEntity();
        given(mockComicDataStore.getComic(FAKE_COMIC_ID)).willReturn(Observable.just(comicEntity));
        comicDataRepository.getComic(FAKE_COMIC_ID);
        verify(mockComicDataStoreFactory).createCloudDataStore();
        verify(mockComicDataStore).getComic(FAKE_COMIC_ID);
    }
}
