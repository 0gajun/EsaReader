package io.github.a0gajun.esareader.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Collection;

import javax.inject.Inject;

import io.github.a0gajun.esareader.domain.model.Post;
import io.github.a0gajun.esareader.presentation.di.component.PostComponent;
import io.github.a0gajun.esareader.presentation.view.PostListView;
import io.github.a0gajun.esareader.presentation.view.presenter.PostListPresenter;

/**
 * Created by Junya on 1/8/17.
 */

public class PostListFragment extends BaseFragment
    implements PostListView {

    @Inject
    PostListPresenter postListPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(PostComponent.class).inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.postListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadPostList();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.postListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.postListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.postListPresenter.destroy();
    }

    private void loadPostList() {
        this.postListPresenter.initialize();
    }

    @Override
    public void renderPostList(Collection<Post> postCollection) {

    }
}
