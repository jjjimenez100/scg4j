package com.jjjimenez.SCG4J.core;

public final class MultipleAccessModifierException extends RuntimeException {
    public MultipleAccessModifierException() {
        super();
    }

    public MultipleAccessModifierException(String message) {
        super(message);
    }

    public MultipleAccessModifierException(String message, Throwable cause) {
        super(message, cause);
    }

    public MultipleAccessModifierException(Throwable cause) {
        super(cause);
    }

    protected MultipleAccessModifierException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
