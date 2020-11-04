package com.tgtech.preferencecenter.repository;

import java.util.UUID;

public class Helper {

    private Helper() {
    }

    public static UUID fromString(String preferenceId) {
        try {
            return UUID.fromString(preferenceId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid preferenceId");
        }

    }
}
