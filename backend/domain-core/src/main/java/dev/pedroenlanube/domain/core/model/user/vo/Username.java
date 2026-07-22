package dev.pedroenlanube.domain.core.model.user.vo;

import java.util.Objects;

public record Username(String value) {
    // An alphanumeric regular expression that allows hyphens and full stops, but not spaces or emojis
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_.-]+$";

    public Username {
        Objects.requireNonNull(value, "Username cannot be null");
        String trimmed = value.trim();
        if (trimmed.length() < 5 || trimmed.length() > 30)
            throw new IllegalArgumentException("Username must be between 5 and 30 characters");

        if (!trimmed.matches(USERNAME_REGEX))
            throw new IllegalArgumentException("Username contains invalid characters");
    }
}
