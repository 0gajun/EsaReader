package io.github.a0gajun.esareader.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.github.a0gajun.esareader.data.entity.mapper.PostMapper;
import io.github.a0gajun.esareader.data.repository.datasource.PostDataStoreFactory;
import io.github.a0gajun.esareader.domain.model.Post;
import io.github.a0gajun.esareader.domain.repository.PostRepository;
import rx.Observable;

/**
 * Created by Junya on 1/6/17.
 */

@Singleton
public class PostRepositoryImpl implements PostRepository {

    private final PostDataStoreFactory postDataStoreFactory;
    private final PostMapper postMapper;

    @Inject
    PostRepositoryImpl(PostDataStoreFactory postDataStoreFactory,
                       PostMapper postMapper) {
        this.postDataStoreFactory = postDataStoreFactory;
        this.postMapper = postMapper;
    }

    @Override
    public Observable<List<Post>> posts(final int pageIndex) {
        return postDataStoreFactory.create()
                .postEntityList(pageIndex)
                .flatMap(postsEntity -> Observable.from(postsEntity.getPosts()))
                .map(postMapper::transform)
                .toList();
    }

    @Override
    public Observable<Post> post(final int postNumber) {
        return postDataStoreFactory.create()
                .postEntityDetail(postNumber)
                .map(postMapper::transform);
    }
}
