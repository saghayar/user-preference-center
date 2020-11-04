package com.tgtech.preferencecenter.error;

public class PreferenceNotFoundException extends RuntimeException {

    public PreferenceNotFoundException() {
    }

    public PreferenceNotFoundException(String message) {
        super(message);
    }
}
