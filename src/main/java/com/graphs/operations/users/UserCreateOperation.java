package com.graphs.operations.users;

import com.graphs.entities.UserEntity;

import java.util.function.Supplier;

public final class UserCreateOperation implements Supplier<Long> {
    public UserCreateOperation(final UserEntity entity) {

    }

    @Override
    public final Long get() {
        return null;
    }
}
