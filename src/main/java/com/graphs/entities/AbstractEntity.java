package com.graphs.entities;

import java.util.Objects;
import java.util.Optional;

public abstract class AbstractEntity {
    public Long id;

    @Override
    public final boolean equals(final Object obj) {
        return obj != null && obj instanceof AbstractEntity && Objects.equals(id, ((AbstractEntity) obj).id);
    }

    @Override
    public final int hashCode() {
        return Optional.ofNullable(id).map( id -> Long.hashCode(id) ).orElse(0);
    }

    @Override
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone method is not supported for entities");
    }

    @Override
    protected final void finalize() throws Throwable {

    }
}
