package com.quanlt.vietcomicclean.domain.executor;

import rx.Scheduler;


public interface PostExecutionThread {
    Scheduler getScheduler();
}
