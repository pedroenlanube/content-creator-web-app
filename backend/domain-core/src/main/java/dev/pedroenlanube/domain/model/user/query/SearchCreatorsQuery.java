package dev.pedroenlanube.domain.model.user.query;

public record SearchCreatorsQuery(String keyword, Integer page, Integer size) {
}
