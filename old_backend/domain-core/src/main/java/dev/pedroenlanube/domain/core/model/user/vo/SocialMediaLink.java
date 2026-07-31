package dev.pedroenlanube.domain.core.model.user.vo;

import dev.pedroenlanube.domain.core.model.user.SocialMediaType;

import java.util.Objects;

public record SocialMediaLink(SocialMediaType type, SecureUrl url) {

    public SocialMediaLink {
        Objects.requireNonNull(type, "The social media type is mandatory");
        Objects.requireNonNull(url, "The social media URL is mandatory");
    }
}
