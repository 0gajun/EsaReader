package io.github.a0gajun.esareader.data.net;

import io.github.a0gajun.esareader.data.entity.PostEntity;
import io.github.a0gajun.esareader.data.entity.PostsEntity;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Junya on 1/6/17.
 */

public interface EsaApi {

    @GET("v1/teams/{team}/posts")
    Observable<PostsEntity> getPosts(@Path("team") String team, @Query("page") int pageIndex);

    @GET("v1/teams/{team}/posts/{post_number}")
    Observable<PostEntity> getPost(@Path("team") String team, @Path("post_number") int post_number);
}
