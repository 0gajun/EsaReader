package io.github.a0gajun.esareader.presentation.di.component;

import dagger.Component;
import io.github.a0gajun.esareader.presentation.di.PerActivity;
import io.github.a0gajun.esareader.presentation.di.module.PostModule;
import io.github.a0gajun.esareader.presentation.view.fragment.PostListFragment;

/**
 * Created by Junya on 1/7/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PostModule.class)
public interface PostComponent {
    void inject(PostListFragment postListFragment);
}
