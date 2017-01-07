package io.github.a0gajun.esareader.presentation.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.a0gajun.esareader.domain.usecase.GetPostList;
import io.github.a0gajun.esareader.domain.usecase.PaginatedUseCase;

/**
 * Created by Junya on 1/7/17.
 */

@Module
public class PostModule {

    @Singleton
    @Provides
    @Named("postList")
    PaginatedUseCase provideGetPostListUseCase(GetPostList getPostList) {
        return getPostList;
    }

}
