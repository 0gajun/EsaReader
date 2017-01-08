package io.github.a0gajun.esareader.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import io.github.a0gajun.esareader.R;
import io.github.a0gajun.esareader.databinding.FragmentPostDetailBinding;
import io.github.a0gajun.esareader.databinding.FragmentPostListBinding;
import io.github.a0gajun.esareader.domain.model.Post;
import io.github.a0gajun.esareader.presentation.di.component.PostComponent;
import io.github.a0gajun.esareader.presentation.view.PostDetailView;
import io.github.a0gajun.esareader.presentation.view.presenter.PostDetailPresenter;

/**
 * Created by Junya on 1/8/17.
 */

public class PostDetailFragment extends BaseFragment
        implements PostDetailView {

    @Inject
    PostDetailPresenter postDetailPresenter;

    private FragmentPostDetailBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(PostComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentPostDetailBinding.bind(getView());

        postDetailPresenter.setView(this);
        if (savedInstanceState == null) {
            postDetailPresenter.initialize();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.postDetailPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.postDetailPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.postDetailPresenter.destroy();
    }

    @Override
    public void renderPostDetail(Post post) {
        binding.setPost(post);
    }
}
