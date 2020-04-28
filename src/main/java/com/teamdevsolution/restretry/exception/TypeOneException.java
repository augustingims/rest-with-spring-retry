package com.teamdevsolution.restretry.exception;

public class TypeOneException extends Exception {
    public TypeOneException() {
        super();
    }

    public TypeOneException(String message) {
        super(message);
    }

    public TypeOneException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeOneException(Throwable cause) {
        super(cause);
    }

    protected TypeOneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
