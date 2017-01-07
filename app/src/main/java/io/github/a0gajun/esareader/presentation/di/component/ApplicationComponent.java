package io.github.a0gajun.esareader.presentation.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import io.github.a0gajun.esareader.domain.repository.PostRepository;
import io.github.a0gajun.esareader.presentation.di.module.ApplicationModule;
import io.github.a0gajun.esareader.presentation.view.activity.BaseActivity;

/**
 * Created by Junya on 1/6/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
    //PostRepository postRepository();
}
