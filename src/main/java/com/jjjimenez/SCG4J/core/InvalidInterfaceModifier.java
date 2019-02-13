package com.jjjimenez.SCG4J.core;

public class InvalidInterfaceModifier extends RuntimeException{
    public InvalidInterfaceModifier() {
        super();
    }

    public InvalidInterfaceModifier(String message) {
        super(message);
    }

    public InvalidInterfaceModifier(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInterfaceModifier(Throwable cause) {
        super(cause);
    }

    protected InvalidInterfaceModifier(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
