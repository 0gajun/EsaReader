package io.github.a0gajun.esareader.presentation.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.a0gajun.esareader.data.repository.PostRepositoryImpl;
import io.github.a0gajun.esareader.domain.repository.PostRepository;
import io.github.a0gajun.esareader.presentation.AndroidApplication;

/**
 * Created by Junya on 1/6/17.
 */

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }


}
