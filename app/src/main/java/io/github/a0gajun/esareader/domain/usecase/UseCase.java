package io.github.a0gajun.esareader.domain.usecase;

import io.github.a0gajun.esareader.domain.executor.PostExecutionThread;
import io.github.a0gajun.esareader.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Abstract class for A Use Case.
 *
 * Created by Junya on 1/7/17.
 */

public abstract class UseCase {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Build Observable which execute business logic.
     *
     * @return Observable
     */
    protected abstract Observable buildUseCaseObservable();

    /**
     * Executes this use case with subscriber
     *
     * @param useCaseSubscriber observer
     */
    @SuppressWarnings("unchecked")
    public void execute(Subscriber useCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);
    }

    /**
     * Unsubscribe current subscription
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
