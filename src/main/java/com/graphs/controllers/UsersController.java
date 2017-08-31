package com.graphs.controllers;

import com.graphs.definitions.Methods;
import com.graphs.definitions.Parameters;
import com.graphs.definitions.Services;
import com.graphs.entities.UserEntity;
import com.graphs.operations.users.UserCreateOperation;
import com.graphs.operations.users.UserGetOperation;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Services.USERS)
public final class UsersController extends AbstractController {
    @Setter(onMethod = @__(@Autowired))
    private UserCreateOperation userCreateOperation;

    @Setter(onMethod = @__(@Autowired))
    private UserGetOperation userGetOperation;

    @RequestMapping(value = Methods.CREATE, method = RequestMethod.POST)
    public final Long create(@RequestBody final UserEntity entity) {
        return perform( () -> userCreateOperation.create(entity) );
    }

    @RequestMapping(value = Methods.GET, method = RequestMethod.GET)
    public final UserEntity get(@RequestParam(value = Parameters.ID) final Long id) {
        return perform( () -> userGetOperation.get(id) );
    }
}
