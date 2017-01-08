package io.github.a0gajun.esareader.presentation.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.github.a0gajun.esareader.domain.executor.PostExecutionThread;
import io.github.a0gajun.esareader.domain.executor.ThreadExecutor;
import io.github.a0gajun.esareader.domain.repository.PostRepository;
import io.github.a0gajun.esareader.domain.usecase.GetPostDetail;
import io.github.a0gajun.esareader.domain.usecase.GetPostList;
import io.github.a0gajun.esareader.domain.usecase.PaginatedUseCase;
import io.github.a0gajun.esareader.domain.usecase.UseCase;
import io.github.a0gajun.esareader.presentation.di.PerActivity;

/**
 * Created by Junya on 1/7/17.
 */

@Module
public class PostModule {

    private int postNumber = -1;

    public PostModule() {
    }

    public PostModule(int postNumber) {
        this.postNumber = postNumber;
    }

    @PerActivity
    @Provides
    @Named("postList")
    PaginatedUseCase provideGetPostListUseCase(GetPostList getPostList) {
        return getPostList;
    }

    @PerActivity
    @Provides
    @Named("postDetail")
    UseCase provideGetPostDetailUseCase(PostRepository postRepository, ThreadExecutor threadExecutor,
                                        PostExecutionThread postExecutionThread) {
        return new GetPostDetail(this.postNumber, postRepository, threadExecutor, postExecutionThread);
    }
}
