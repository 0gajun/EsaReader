package io.github.a0gajun.esareader.domain.usecase;

import javax.inject.Inject;

import io.github.a0gajun.esareader.domain.executor.PostExecutionThread;
import io.github.a0gajun.esareader.domain.executor.ThreadExecutor;
import io.github.a0gajun.esareader.domain.repository.PostRepository;
import rx.Observable;

/**
 * Created by Junya on 1/8/17.
 */

public class GetPostDetail extends UseCase {

    private final PostRepository postRepository;
    private final int postNumber;

    @Inject
    public GetPostDetail(int postNumber,
                         PostRepository postRepository,
                         ThreadExecutor threadExecutor,
                         PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.postRepository = postRepository;
        this.postNumber = postNumber;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.postRepository.post(this.postNumber);
    }
}
