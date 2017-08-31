package com.graphs.controllers;

import com.graphs.definitions.Services;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Services.VERTICES)
public final class VerticesController extends AbstractController {
}
