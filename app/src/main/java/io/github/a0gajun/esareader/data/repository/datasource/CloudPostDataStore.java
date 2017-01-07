package io.github.a0gajun.esareader.data.repository.datasource;

import java.util.List;

import javax.inject.Inject;

import io.github.a0gajun.esareader.data.entity.PostEntity;
import io.github.a0gajun.esareader.data.entity.PostsEntity;
import io.github.a0gajun.esareader.data.net.EsaApi;
import rx.Observable;

/**
 * Created by Junya on 1/6/17.
 */

public class CloudPostDataStore implements PostDataStore {
    private static final String TEAM_NAME = "0gajun";

    private final EsaApi esaApi;

    public CloudPostDataStore(EsaApi esaApi) {
        this.esaApi = esaApi;
    }

    @Override
    public Observable<PostsEntity> postEntityList(final int pageIndex) {
        return this.esaApi.getPosts(TEAM_NAME, pageIndex);
    }

    @Override
    public Observable<PostEntity> postEntityDetail(final int postNumber) {
        return this.esaApi.getPost(TEAM_NAME, postNumber);
    }
}
