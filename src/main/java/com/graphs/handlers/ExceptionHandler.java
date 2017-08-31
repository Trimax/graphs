package com.graphs.handlers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public final class ExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = Logger.getLogger(ExceptionHandler.class);

    @Override
    protected final ResponseEntity<Object> handleExceptionInternal(final Exception exception, final Object body, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        logger.error(exception.getMessage());

        headers.add("Content-Type", "text/html");
        return super.handleExceptionInternal(exception, body, headers, status, request);
    }
}