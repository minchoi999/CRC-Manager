package com.cr.cmanager.framework.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidParameterException extends Exception {

    private String message;
    private Throwable cause;

    public InvalidParameterException(final String message) {
        super(message);
        this.message = message;
    }

    public InvalidParameterException(final Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public InvalidParameterException(final String message, final Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }
}
