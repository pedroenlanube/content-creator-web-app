package dev.pedroenlanube.domain.core.model.user.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public record SecureUrl(String value) {
    // A regular expression that requires the use of http or https and a valid domain structure
    private static final Pattern URL_PATTERN = Pattern.compile("^https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}.*$");

    public SecureUrl {
        Objects.requireNonNull(value, "URL cannot be null");
        String trimmed = value.trim();

        if (trimmed.isBlank()) {
            throw new IllegalArgumentException("URL cannot be empty");
        }

        if (!URL_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException("Invalid URL format. Must start with http:// or https://");
        }
    }
}
