package com.graphs.operations.users;

import com.graphs.entities.UserEntity;
import com.graphs.mappers.UserMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class UserCreateOperation {
    @Setter(onMethod = @__(@Autowired))
    private UserMapper userMapper;

    public final Long create(final UserEntity entity) {
        return userMapper.create(entity);
    }
}
