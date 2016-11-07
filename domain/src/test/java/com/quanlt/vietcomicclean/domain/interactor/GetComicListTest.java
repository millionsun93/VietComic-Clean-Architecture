package com.quanlt.vietcomicclean.domain.interactor;

import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;
import com.quanlt.vietcomicclean.domain.repository.ComicRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class GetComicListTest {

    private static final int FAKE_PAGE = 1;

    private GetComicList getComicList;
    @Mock
    private PostExecutionThread postExecutionThread;
    @Mock
    private ThreadExecutor executionException;
    @Mock
    private ComicRepository comicRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        getComicList = new GetComicList(FAKE_PAGE, comicRepository, executionException, postExecutionThread);
    }

    @Test
    public void testGetComicListUseCaseObservable() throws Exception {
        getComicList.buildUseCaseObservable();
        verify(comicRepository).getComics(FAKE_PAGE);
        verifyNoMoreInteractions(comicRepository);
        verifyZeroInteractions(executionException);
        verifyZeroInteractions(postExecutionThread);
    }
}
