package io.github.a0gajun.esareader.presentation.view.presenter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.github.a0gajun.esareader.domain.model.Post;
import io.github.a0gajun.esareader.domain.usecase.DefaultSubscriber;
import io.github.a0gajun.esareader.domain.usecase.PaginatedUseCase;
import io.github.a0gajun.esareader.presentation.view.PostListView;
import timber.log.Timber;

/**
 * Created by Junya on 1/8/17.
 */

public class PostListPresenter implements Presenter {
    private PostListView postListView;
    private int currentPageIndex = 0;
    private Collection<Post> postCollection = new ArrayList<>();

    private final PaginatedUseCase getPostListUseCase;

    @Inject
    public PostListPresenter(@Named("postList") PaginatedUseCase getPostListUsecase) {
        this.getPostListUseCase = getPostListUsecase;
    }

    public void setView(@NonNull PostListView postListView) {
        this.postListView = postListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getPostListUseCase.unsubscribe();
        this.postListView = null;
        this.postCollection = null;
    }

    public void initialize() {
        currentPageIndex = 0;
        this.clearPostCollection();
        this.loadPostList(0);
    }

    public void loadNext() {
        currentPageIndex++;
        this.loadPostList(currentPageIndex);
    }

    private void loadPostList(final int pageIndex) {
        this.getPostList(pageIndex);
    }

    private void getPostList(final int pageIndex) {
        this.getPostListUseCase.execute(new PostListSubscriber(), pageIndex);
    }

    private void showPostsCollectionInView() {
        this.postListView.renderPostList(this.postCollection);
    }

    private void addAllPostCollection(Collection<Post> postCollection) {
        this.postCollection.addAll(postCollection);
    }

    private void clearPostCollection() {
        this.postCollection.clear();
    }

    private final class PostListSubscriber extends DefaultSubscriber<List<Post>> {
        @Override
        public void onError(Throwable e) {
            Timber.e(e);
            super.onError(e);
        }

        @Override
        public void onNext(List<Post> posts) {
            PostListPresenter.this.addAllPostCollection(posts);
            PostListPresenter.this.showPostsCollectionInView();
        }
    }
}
