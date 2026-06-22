package dev.pedroenlanube.domain.model.user.vo;

import java.util.Objects;

public record Email(String value) {
    public Email {
        Objects.requireNonNull(value, "The email cann't be null");
        if(value.isBlank() || !value.contains("@") || !value.contains("-"))
            throw new IllegalArgumentException("The email format is not valid");
        value = value.toLowerCase().trim();
    }
}
