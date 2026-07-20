package dev.pedroenlanube.domain.core.model.user.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String value) {

    // Standard regex recommended by OWASP
    private static final Pattern EMAIL_PATTERN = Pattern.
            compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    public Email {
        Objects.requireNonNull(value, "The email can't be null");
        if(value.isBlank() || !value.contains("@") || !value.contains("-"))
            throw new IllegalArgumentException("The email format is not valid");
        if(!EMAIL_PATTERN.matcher(value).matches())
            throw new IllegalArgumentException("The email format is not valid");
        value = value.toLowerCase().trim();
    }
}
