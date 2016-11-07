package com.quanlt.vietcomicclean.data.repository.datastore;

import com.quanlt.vietcomicclean.data.ApplicationTestCase;
import com.quanlt.vietcomicclean.data.entity.ComicEntity;
import com.quanlt.vietcomicclean.data.entity.ComicResponse;
import com.quanlt.vietcomicclean.data.exception.ComicNotFoundException;
import com.quanlt.vietcomicclean.data.net.ComicApiService;
import com.quanlt.vietcomicclean.data.repository.datasource.ComicRetrofitDataStore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoAssertionError;

import java.util.List;

import edu.emory.mathcs.backport.java.util.Arrays;
import rx.Observable;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


public class ComicRetrofitDataStoreTest extends ApplicationTestCase {
    private static final String FAKE_COMIC_ID = "12345";
    private ComicRetrofitDataStore comicRetrofitDataStore;
    @Mock
    private ComicApiService mockComicApiService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        comicRetrofitDataStore = new ComicRetrofitDataStore(mockComicApiService);
    }

    @Test
    public void testGetComicsFromApi() {
        final int page = anyInt();
        ComicResponse<List<ComicEntity>> fakeResponse = new ComicResponse<>();
        fakeResponse.setData(Arrays.asList(new ComicEntity[]{new ComicEntity()}));
        Observable<ComicResponse<List<ComicEntity>>> fakeObservable = Observable.just(fakeResponse);
        given(mockComicApiService.getComics(page)).willReturn(fakeObservable);
        comicRetrofitDataStore.getComics(page);
        verify(mockComicApiService).getComics(page);
    }

    @Test
    public void testGetComicEntityDetailFromApi() throws Exception {
        ComicEntity fakeComicEntity = new ComicEntity();
        ComicResponse<ComicEntity> fakeResponse = new ComicResponse<>();
        fakeResponse.setData(fakeComicEntity);
        Observable<ComicResponse<ComicEntity>> fakeObservable = Observable.just(fakeResponse);
        given(mockComicApiService.getComicDetail(FAKE_COMIC_ID)).willReturn(fakeObservable);
        comicRetrofitDataStore.getComic(FAKE_COMIC_ID);
        verify(mockComicApiService).getComicDetail(FAKE_COMIC_ID);
    }
}
