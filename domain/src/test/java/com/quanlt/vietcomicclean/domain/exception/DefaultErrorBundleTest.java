package com.quanlt.vietcomicclean.domain.exception;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


public class DefaultErrorBundleTest {
    private DefaultErrorBundle defaultErrorBundle;
    @Mock
    private Exception mockException;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        defaultErrorBundle = new DefaultErrorBundle(mockException);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        defaultErrorBundle.getErrorMessage();
        verify(mockException).getMessage();
    }
}
