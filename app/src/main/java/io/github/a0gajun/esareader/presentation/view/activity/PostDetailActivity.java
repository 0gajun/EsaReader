package io.github.a0gajun.esareader.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import io.github.a0gajun.esareader.R;
import io.github.a0gajun.esareader.databinding.ActivityLayoutBinding;
import io.github.a0gajun.esareader.presentation.di.HasComponent;
import io.github.a0gajun.esareader.presentation.di.component.DaggerPostComponent;
import io.github.a0gajun.esareader.presentation.di.component.PostComponent;
import io.github.a0gajun.esareader.presentation.di.module.PostModule;
import io.github.a0gajun.esareader.presentation.view.fragment.PostDetailFragment;

/**
 * Created by Junya on 1/8/17.
 */

public class PostDetailActivity extends BaseActivity
        implements HasComponent<PostComponent> {

    enum INTENT_KEY {
        POST_NUMBER
    }

    public static Intent getCallingIntent(Context context, final int postNumber) {
        Intent callingIntent = new Intent(context, PostDetailActivity.class);
        callingIntent.putExtra(INTENT_KEY.POST_NUMBER.name(), postNumber);
        return callingIntent;
    }

    private ActivityLayoutBinding binding;
    private PostComponent postComponent;
    private int postNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_layout);

        initializeActivity(savedInstanceState);
        initializeInjector();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (outState != null) {
            outState.putInt(INTENT_KEY.POST_NUMBER.name(), this.postNumber);
        }
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.postNumber = getIntent().getIntExtra(INTENT_KEY.POST_NUMBER.name(), -1);
            addFragment(R.id.fragment_container, new PostDetailFragment());
        } else {
            this.postNumber = savedInstanceState.getInt(INTENT_KEY.POST_NUMBER.name());
        }
    }

    private void initializeInjector() {
        this.postComponent = DaggerPostComponent.builder()
                .applicationComponent(getApplicationComponent())
                .postModule(new PostModule(this.postNumber))
                .build();
    }

    @Override
    public PostComponent getComponent() {
        return this.postComponent;
    }
}
