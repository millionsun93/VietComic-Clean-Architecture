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


public class GetComicDetailTest {
    private final String FAKE_COMIC_ID = "123456";
    private GetComicDetail getComicDetail;

    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private PostExecutionThread postExecutionThread;
    @Mock
    private ComicRepository comicRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        getComicDetail = new GetComicDetail(FAKE_COMIC_ID, comicRepository, threadExecutor, postExecutionThread);
    }

    @Test
    public void testGetComicDetailUseCaseObservable() throws Exception {
        getComicDetail.buildUseCaseObservable();
        verify(comicRepository).getComic(FAKE_COMIC_ID);
        verifyNoMoreInteractions(comicRepository);
        verifyZeroInteractions(threadExecutor);
        verifyZeroInteractions(postExecutionThread);
    }
}
