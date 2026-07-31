package dev.pedroenlanube.domain.core.model.content.vo;

import dev.pedroenlanube.domain.core.model.content.ResourceType;

import java.util.Objects;

public record MultimediaResource(String s3Key, ResourceType type, Long size) {
    public MultimediaResource {
        Objects.requireNonNull(type, "The resource type is mandatory");
        if(s3Key == null || s3Key.isBlank()){
            throw new IllegalArgumentException("The S3 key is mandatory");
        }
        if(size == null || size <= 0){
            throw new IllegalArgumentException("The size must be a positive number");
        }
    }
}
