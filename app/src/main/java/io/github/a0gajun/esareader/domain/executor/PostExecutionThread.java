package io.github.a0gajun.esareader.domain.executor;

import rx.Scheduler;

/**
 * Created by Junya on 1/7/17.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
