package io.github.a0gajun.esareader.presentation.di.component;

import javax.inject.Singleton;

import dagger.Component;
import io.github.a0gajun.esareader.presentation.di.module.ApplicationModule;
import io.github.a0gajun.esareader.presentation.di.module.NetModule;
import io.github.a0gajun.esareader.presentation.view.activity.BaseActivity;

/**
 * Created by Junya on 1/7/17.
 */

@Singleton
@Component(dependencies = ApplicationModule.class, modules = NetModule.class)
public interface NetComponent {
    void inject(BaseActivity activity);
}
