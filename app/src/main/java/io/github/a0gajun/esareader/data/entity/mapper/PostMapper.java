package io.github.a0gajun.esareader.data.entity.mapper;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.github.a0gajun.esareader.data.entity.PostEntity;
import io.github.a0gajun.esareader.domain.model.Post;

/**
 * Created by Junya on 1/7/17.
 */

@Singleton
public class PostMapper {
    private UserMapper userMapper;

    @Inject
    public PostMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Post transform(PostEntity entity) {
        Post post = null;

        if (entity != null) {
            post = new Post();
            post.setPostNumber(entity.getPostNumber());
            post.setTitle(entity.getTitle());
            post.setTags(new ArrayList<>(entity.getTags()));
            post.setCategory(entity.getCategory());
            post.setFullName(entity.getFullName());
            post.setWip(entity.isWip());
            post.setMdBody(entity.getMdBody());
            post.setHtmlBody(entity.getHtmlBody());
            post.setCreatedAt(entity.getCreatedAt());
            post.setUpdatedAt(entity.getUpdatedAt());
            post.setUpdateMessage(entity.getUpdateMessage());
            post.setRevisionNumber(entity.getRevisionNumber());
            post.setCreatedBy(userMapper.transform(entity.getCreatedBy()));
            post.setUpdatedBy(userMapper.transform(entity.getUpdatedBy()));
            post.setKind(entity.getKind());
            post.setTasksCount(entity.getTasksCount());
            post.setDoneTasksCount(entity.getDoneTasksCount());
            post.setStargazersCount(entity.getStargazersCount());
            post.setWatchersCount(entity.getWatchersCount());
            post.setStared(entity.isStared());
            post.setWatching(entity.isWatching());
        }
        return post;
    }
}
