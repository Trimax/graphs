package com.graphs.operations.users;

import com.graphs.entities.UserEntity;
import com.graphs.mappers.UserMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class UserGetOperation {
    @Setter(onMethod = @__(@Autowired))
    private UserMapper userMapper;

    public final UserEntity get(final Long id) {
        return userMapper.get(id);
    }
}
