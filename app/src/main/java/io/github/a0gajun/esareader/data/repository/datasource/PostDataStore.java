package io.github.a0gajun.esareader.data.repository.datasource;

import java.util.List;

import io.github.a0gajun.esareader.data.entity.PostEntity;
import io.github.a0gajun.esareader.data.entity.PostsEntity;
import rx.Observable;

/**
 * Created by Junya on 1/6/17.
 */

public interface PostDataStore {

    Observable<PostsEntity> postEntityList(final int pageIndex);

    Observable<PostEntity> postEntityDetail(final int postNumber);
}
