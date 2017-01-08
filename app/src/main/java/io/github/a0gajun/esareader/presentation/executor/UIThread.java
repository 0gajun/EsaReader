package io.github.a0gajun.esareader.presentation.executor;

import javax.inject.Inject;

import io.github.a0gajun.esareader.domain.executor.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * UIThread scheduler
 *
 * Created by Junya on 1/8/17.
 */

public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
