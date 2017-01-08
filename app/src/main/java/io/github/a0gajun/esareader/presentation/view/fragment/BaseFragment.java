package io.github.a0gajun.esareader.presentation.view.fragment;

import android.support.v4.app.Fragment;

import io.github.a0gajun.esareader.presentation.di.HasComponent;

/**
 * Base Fragment class.
 *
 * Created by Junya on 1/8/17.
 */

public abstract class BaseFragment extends Fragment {

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
