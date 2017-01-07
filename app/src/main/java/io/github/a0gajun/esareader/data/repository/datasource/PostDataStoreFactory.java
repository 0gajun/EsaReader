package io.github.a0gajun.esareader.data.repository.datasource;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.github.a0gajun.esareader.data.net.EsaApi;

/**
 * Created by Junya on 1/6/17.
 */

@Singleton
public class PostDataStoreFactory {

    private final Context context;
    private final EsaApi esaApi;

    @Inject
    PostDataStoreFactory(Context context, EsaApi esaApi) {
        this.context = context;
        this.esaApi = esaApi;
    }

    public PostDataStore create() {
        return createCloudDataStore();
    }

    private PostDataStore createCloudDataStore() {
        return new CloudPostDataStore(esaApi);
    }
}
