package io.github.a0gajun.esareader.presentation.view;

import java.util.Collection;

import io.github.a0gajun.esareader.domain.model.Post;

/**
 * Created by Junya on 1/8/17.
 */

public interface PostListView {
    void renderPostList(Collection<Post> postCollection);
}
