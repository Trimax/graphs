package com.graphs.controllers;

import com.graphs.definitions.Methods;
import com.graphs.definitions.Services;
import com.graphs.entities.UserEntity;
import com.graphs.operations.users.UserCreateOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = Services.USERS)
public final class UsersController extends AbstractController {
    @RequestMapping(value = Methods.CREATE, method = RequestMethod.POST)
    public final Long create(@RequestBody final UserEntity entity) {
        return perform(new UserCreateOperation(entity));
    }
}
