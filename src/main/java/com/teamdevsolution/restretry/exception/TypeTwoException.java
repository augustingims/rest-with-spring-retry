package com.teamdevsolution.restretry.exception;

public class TypeTwoException extends Exception {
    public TypeTwoException() {
        super();
    }

    public TypeTwoException(String message) {
        super(message);
    }

    public TypeTwoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeTwoException(Throwable cause) {
        super(cause);
    }

    protected TypeTwoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
