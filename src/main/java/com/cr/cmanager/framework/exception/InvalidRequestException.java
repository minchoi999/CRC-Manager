package com.cr.cmanager.framework.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidRequestException extends Exception {

    private String message;
    private Throwable cause;

    public InvalidRequestException(final String message) {
        super(message);
        this.message = message;
    }

    public InvalidRequestException(final Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public InvalidRequestException(final String message, final Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }
}
