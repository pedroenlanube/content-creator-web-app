package dev.pedroenlanube.domain.core.model.user.query;

public record SearchCreatorsQuery(String keyword, Integer page, Integer size) {
}
