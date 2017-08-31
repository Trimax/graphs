package com.graphs.controllers;

import java.util.function.Supplier;

public abstract class AbstractController {
    protected final <T> T perform(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (final Throwable t) {
            throw new RuntimeException("Can't perform operation: " + supplier.getClass().getSimpleName(), t);
        }
    }
}
