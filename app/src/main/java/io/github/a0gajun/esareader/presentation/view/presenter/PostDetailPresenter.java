package io.github.a0gajun.esareader.presentation.view.presenter;

import android.support.annotation.NonNull;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Named;

import io.github.a0gajun.esareader.domain.model.Post;
import io.github.a0gajun.esareader.domain.usecase.DefaultSubscriber;
import io.github.a0gajun.esareader.domain.usecase.GetPostDetail;
import io.github.a0gajun.esareader.domain.usecase.UseCase;
import io.github.a0gajun.esareader.presentation.view.PostDetailView;
import timber.log.Timber;

/**
 * Created by Junya on 1/8/17.
 */

public class PostDetailPresenter implements Presenter {

    private PostDetailView postDetailView;
    private UseCase postDetailUseCase;
    private Post post;

    @Inject
    public PostDetailPresenter(@Named("postDetail") UseCase postDetailUseCase) {
        this.postDetailUseCase = postDetailUseCase;
    }

    public void setView(PostDetailView postDetailView) {
        this.postDetailView = postDetailView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.postDetailUseCase = null;
    }

    public void initialize() {
        this.postDetailUseCase.execute(new PostDetailSubscriber());
    }

    private void setPost(Post post) {
        this.post = post;
    }

    private void render() {
        if (this.post == null) {
            return;
        }
        this.postDetailView.renderPostDetail(this.post);
    }

    private final class PostDetailSubscriber extends DefaultSubscriber<Post> {
        @Override
        public void onError(Throwable e) {
            Timber.e(e);
            super.onError(e);
        }

        @Override
        public void onNext(Post post) {
            PostDetailPresenter.this.setPost(post);
            PostDetailPresenter.this.render();
        }
    }

}
