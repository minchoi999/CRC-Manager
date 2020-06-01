package com.cr.cmanager.framework.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidRequestExceptionTest {

    private static final String EXCEPTION_MESSAGE = "message";

    private static final Throwable THROWABLE = new Throwable();

    private InvalidRequestException exception;

    @Test
    public void testGetMessage() {
        exception = new InvalidRequestException(EXCEPTION_MESSAGE, THROWABLE);

        assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
        assertEquals(THROWABLE, exception.getCause());
    }
}
