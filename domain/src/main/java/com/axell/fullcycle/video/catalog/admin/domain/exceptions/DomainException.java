package com.axell.fullcycle.video.catalog.admin.domain.exceptions;

import java.util.List;

import com.axell.fullcycle.video.catalog.admin.domain.validation.Error;

public class DomainException extends RuntimeException {
    private final List<Error> errors;

    private DomainException(final List<Error> errors) {
        super("", null, true, false);
        this.errors = errors;
    }

    public static DomainException with(final List<Error> errors) {
        return new DomainException(errors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
