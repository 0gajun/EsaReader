package io.github.a0gajun.esareader.presentation.view.activity;

import android.os.Bundle;

import io.github.a0gajun.esareader.R;
import io.github.a0gajun.esareader.presentation.di.HasComponent;
import io.github.a0gajun.esareader.presentation.di.component.DaggerPostComponent;
import io.github.a0gajun.esareader.presentation.di.component.PostComponent;

public class PostListActivity extends BaseActivity
        implements HasComponent<PostComponent> {

    private PostComponent postComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeInjector();

    }

    private void initializeInjector() {
        this.postComponent = DaggerPostComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build();
    }

    @Override
    public PostComponent getComponent() {
        return postComponent;
    }
}
