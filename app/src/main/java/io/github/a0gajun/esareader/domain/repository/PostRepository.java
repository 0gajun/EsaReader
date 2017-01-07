package io.github.a0gajun.esareader.domain.repository;

import java.util.List;

import io.github.a0gajun.esareader.domain.model.Post;
import rx.Observable;

/**
 * Created by Junya on 1/6/17.
 */

public interface PostRepository {

    Observable<List<Post>> posts(final int pageIndex);

    Observable<Post> post(final int postNumber);
}
