package io.github.a0gajun.esareader.domain.usecase;

import javax.inject.Inject;

import io.github.a0gajun.esareader.domain.executor.PostExecutionThread;
import io.github.a0gajun.esareader.domain.executor.ThreadExecutor;
import io.github.a0gajun.esareader.domain.repository.PostRepository;
import rx.Observable;

/**
 * Created by Junya on 1/7/17.
 */

public class GetPostList extends PaginatedUseCase {

    private final PostRepository postRepository;

    @Inject
    public GetPostList(ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread,
                       PostRepository postRepository) {
        super(threadExecutor, postExecutionThread);
        this.postRepository = postRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.postRepository.posts(getPageIndex());
    }
}
