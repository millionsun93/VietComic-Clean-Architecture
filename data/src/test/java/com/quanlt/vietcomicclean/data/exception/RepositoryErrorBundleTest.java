package com.quanlt.vietcomicclean.data.exception;

import com.quanlt.vietcomicclean.data.ApplicationTestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


public class RepositoryErrorBundleTest extends ApplicationTestCase {
    private RepositoryErrorBundle repositoryErrorBundle;

    @Mock
    Exception mockException;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        repositoryErrorBundle = new RepositoryErrorBundle(mockException);
    }

    @Test
    public void testGetErrorMessage() {
        repositoryErrorBundle.getErrorMessage();
        verify(mockException).getMessage();

    }
}
