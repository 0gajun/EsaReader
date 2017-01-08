package io.github.a0gajun.esareader.presentation.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import io.github.a0gajun.esareader.R;
import io.github.a0gajun.esareader.databinding.ActivityLayoutBinding;
import io.github.a0gajun.esareader.domain.model.Post;
import io.github.a0gajun.esareader.presentation.di.HasComponent;
import io.github.a0gajun.esareader.presentation.di.component.DaggerPostComponent;
import io.github.a0gajun.esareader.presentation.di.component.PostComponent;
import io.github.a0gajun.esareader.presentation.di.module.PostModule;
import io.github.a0gajun.esareader.presentation.view.fragment.PostListFragment;

public class PostListActivity extends BaseActivity
        implements HasComponent<PostComponent>, PostListFragment.PostListListener {

    private ActivityLayoutBinding binding;
    private PostComponent postComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_layout);
        this.initializeInjector();

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new PostListFragment());
        }
    }

    private void initializeInjector() {
        this.postComponent = DaggerPostComponent.builder()
                .applicationComponent(getApplicationComponent())
                .postModule(new PostModule())
                .build();
    }

    @Override
    public PostComponent getComponent() {
        return postComponent;
    }

    @Override
    public void onPostClicked(Post post) {
        startActivity(PostDetailActivity.getCallingIntent(this, post.getPostNumber()));
    }
}
