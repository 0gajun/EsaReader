package io.github.a0gajun.esareader.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;

import javax.inject.Inject;

import io.github.a0gajun.esareader.R;
import io.github.a0gajun.esareader.databinding.FragmentPostListBinding;
import io.github.a0gajun.esareader.domain.model.Post;
import io.github.a0gajun.esareader.presentation.di.component.PostComponent;
import io.github.a0gajun.esareader.presentation.view.PostListView;
import io.github.a0gajun.esareader.presentation.view.adapter.PostsAdapter;
import io.github.a0gajun.esareader.presentation.view.presenter.PostListPresenter;

/**
 * Created by Junya on 1/8/17.
 */

public class PostListFragment extends BaseFragment
        implements PostListView {

    private FragmentPostListBinding binding;

    @Inject
    PostListPresenter postListPresenter;
    @Inject
    PostsAdapter postsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(PostComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_post_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding = FragmentPostListBinding.bind(getView());
        setUpRecyclerView();

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
        if (postCollection == null) {
            return;
        }
        this.postsAdapter.setPostsCollection(postCollection);
    }

    private Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void setUpRecyclerView() {
        this.binding.rvPosts.setLayoutManager(new LinearLayoutManager(context()));
        this.binding.rvPosts.setAdapter(postsAdapter);
    }
}
