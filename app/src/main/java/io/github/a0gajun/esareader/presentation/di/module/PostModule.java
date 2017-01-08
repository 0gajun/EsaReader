package io.github.a0gajun.esareader.presentation.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.github.a0gajun.esareader.domain.usecase.GetPostList;
import io.github.a0gajun.esareader.domain.usecase.PaginatedUseCase;
import io.github.a0gajun.esareader.presentation.di.PerActivity;

/**
 * Created by Junya on 1/7/17.
 */

@Module
public class PostModule {

    @PerActivity
    @Provides
    @Named("postList")
    PaginatedUseCase provideGetPostListUseCase(GetPostList getPostList) {
        return getPostList;
    }

}
