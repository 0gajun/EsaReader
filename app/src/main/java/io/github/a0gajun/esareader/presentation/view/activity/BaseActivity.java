package io.github.a0gajun.esareader.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import io.github.a0gajun.esareader.presentation.AndroidApplication;
import io.github.a0gajun.esareader.presentation.di.component.ApplicationComponent;
import io.github.a0gajun.esareader.presentation.di.module.NetModule;

/**
 * Created by Junya on 1/6/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * Attach fragment to this activity.
     *
     * @param containerViewId
     * @param fragment
     */
    protected void addFragment(final int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Helper method for getting ApplicationComponent.
     *
     * @return
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    protected NetModule getNetModule() {
        return new NetModule("https://api.esa.io/"); // TODO: don't use immediate value
    }
}
