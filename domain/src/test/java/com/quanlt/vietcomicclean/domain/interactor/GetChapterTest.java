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

public class GetChapterTest {
    private static final String FAKE_COMIC_ID = "123456";
    private static final String FAKE_CHAPTER_NAME = "chapter 1";

    private GetChapter getChapter;

    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private PostExecutionThread postExecutionThread;
    @Mock
    ComicRepository comicRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        getChapter = new GetChapter(FAKE_COMIC_ID, FAKE_CHAPTER_NAME, comicRepository, threadExecutor, postExecutionThread);
    }

    @Test
    public void testGetChapterUseCaseObservable() throws Exception {
        getChapter.buildUseCaseObservable();
        verify(comicRepository).getChapter(FAKE_COMIC_ID, FAKE_CHAPTER_NAME);
        verifyNoMoreInteractions(comicRepository);
        verifyZeroInteractions(threadExecutor);
        verifyZeroInteractions(postExecutionThread);
    }
}
