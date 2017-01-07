package io.github.a0gajun.esareader.data.entity.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.github.a0gajun.esareader.data.entity.UserEntity;
import io.github.a0gajun.esareader.domain.model.User;

/**
 * Created by Junya on 1/7/17.
 */

@Singleton
public class UserMapper {

    @Inject
    public UserMapper() {
    }

    public User transform(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        User user = new User();
        user.setName(entity.getName());
        user.setIconUrl(entity.getIconUrl());
        user.setScreenName(entity.getScreenName());
        return user;
    }
}
