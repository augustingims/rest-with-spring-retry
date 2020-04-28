package com.teamdevsolution.restretry.exception;

public class CountryNotFoundException extends Exception {
    public CountryNotFoundException() {
        super();
    }

    public CountryNotFoundException(String message) {
        super(message);
    }

    public CountryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CountryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
