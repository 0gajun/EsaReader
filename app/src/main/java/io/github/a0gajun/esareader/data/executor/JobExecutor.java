package io.github.a0gajun.esareader.data.executor;

import android.support.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;

import io.github.a0gajun.esareader.domain.executor.ThreadExecutor;

/**
 * JobExecutor used by Rx
 *
 * Created by Junya on 1/8/17.
 */

public class JobExecutor implements ThreadExecutor {

    private final ExecutorService executorService;

    @Inject
    public JobExecutor() {
        this.executorService = Executors.newCachedThreadPool(new JobThreadFactory());
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new IllegalArgumentException("Runnable cannot be null.");
        }
        this.executorService.execute(command);
    }

    private static class JobThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME_PREFIX = "android_esa_reader_";
        private int counter = 0;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, THREAD_NAME_PREFIX + counter++);
        }
    }
}
