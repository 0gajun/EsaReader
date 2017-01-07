package io.github.a0gajun.esareader.domain.usecase;

import io.github.a0gajun.esareader.domain.executor.PostExecutionThread;
import io.github.a0gajun.esareader.domain.executor.ThreadExecutor;
import rx.Subscriber;

/**
 * Abstract Class of Use Case which uses a paginated resource.
 *
 * Created by Junya on 1/7/17.
 */

public abstract class PaginatedUseCase extends UseCase {

    private int pageIndex = 0;

    public PaginatedUseCase(ThreadExecutor threadExecutor,
                            PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    /**
     * In PaginatedUseCase, this method isn't active.
     *
     * @param useCaseSubscriber observer
     */
    @Deprecated
    @Override
    public void execute(Subscriber useCaseSubscriber) {
        throw new IllegalAccessError("Calling this method isn't allowed.");
    }

    // TODO: Is using synchronized ok?
    public synchronized void execute(Subscriber useCaseSubscriber, int pageIndex) {
        this.pageIndex = pageIndex;
        super.execute(useCaseSubscriber);
    }

    /**
     * Get page index for pagination.
     *
     * @return
     */
    protected int getPageIndex() {
        return pageIndex;
    }
}
