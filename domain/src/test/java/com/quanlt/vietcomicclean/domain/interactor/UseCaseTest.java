package com.quanlt.vietcomicclean.domain.interactor;

import com.quanlt.vietcomicclean.domain.executor.PostExecutionThread;
import com.quanlt.vietcomicclean.domain.executor.ThreadExecutor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.Subscriber;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;


public class UseCaseTest {
    private UseCaseTestClass useCase;
    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private PostExecutionThread postExecutionThread;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.useCase = new UseCaseTestClass(threadExecutor, postExecutionThread);
    }

    @Test
    public void testBuildUseCaseObservableReturnCorrectResult() throws Exception {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        TestScheduler testScheduler = new TestScheduler();
        given(postExecutionThread.getScheduler()).willReturn(testScheduler);
        useCase.execute(testSubscriber);
        assertThat(testSubscriber.getOnNextEvents().size(), is(0));
    }

    @Test
    public void testSubscriptionWhenExecutingUseCase() {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        useCase.execute(testSubscriber);
        useCase.unsubscribe();
        assertThat(testSubscriber.isUnsubscribed(), is(true));
    }

    private class UseCaseTestClass extends UseCase {

        public UseCaseTestClass(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
            super(threadExecutor, postExecutionThread);
        }

        @Override
        protected Observable buildUseCaseObservable() {
            return Observable.empty();
        }

        @Override
        public void execute(Subscriber useCaseSubscriber) {
            super.execute(useCaseSubscriber);
        }
    }
}
