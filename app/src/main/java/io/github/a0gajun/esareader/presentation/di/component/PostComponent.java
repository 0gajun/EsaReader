package io.github.a0gajun.esareader.presentation.di.component;

import javax.inject.Singleton;

import dagger.Component;
import io.github.a0gajun.esareader.presentation.di.module.NetModule;
import io.github.a0gajun.esareader.presentation.di.module.PostModule;
import io.github.a0gajun.esareader.presentation.view.activity.BaseActivity;

/**
 * Created by Junya on 1/7/17.
 */

@Singleton
@Component(dependencies = NetModule.class, modules = PostModule.class)
public interface PostComponent {
    void inject(BaseActivity baseActivity);
}
