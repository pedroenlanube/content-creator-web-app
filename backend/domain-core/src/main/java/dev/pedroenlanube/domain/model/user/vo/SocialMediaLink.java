package dev.pedroenlanube.domain.model.user.vo;

import dev.pedroenlanube.domain.model.user.SocialMediaType;

import java.util.Objects;

public record SocialMediaLink(SocialMediaType type, String url) {
    public SocialMediaLink {
        Objects.requireNonNull(type, "The social media type is mandatory");
        if(url == null || url.isBlank())
            throw new IllegalArgumentException("The social media url is mandatory");
    }
}
