package com.graphs.controllers;

import com.graphs.definitions.Services;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Services.GRAPHS)
public final class GraphsController extends AbstractController {
}
