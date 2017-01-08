package io.github.a0gajun.esareader.presentation.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.a0gajun.esareader.data.executor.JobExecutor;
import io.github.a0gajun.esareader.data.repository.PostRepositoryImpl;
import io.github.a0gajun.esareader.domain.executor.PostExecutionThread;
import io.github.a0gajun.esareader.domain.executor.ThreadExecutor;
import io.github.a0gajun.esareader.domain.repository.PostRepository;
import io.github.a0gajun.esareader.presentation.AndroidApplication;
import io.github.a0gajun.esareader.presentation.executor.UIThread;

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
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
