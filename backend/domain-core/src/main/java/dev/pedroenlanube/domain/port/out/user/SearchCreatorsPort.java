package dev.pedroenlanube.domain.port.out.user;

import dev.pedroenlanube.domain.model.generic.PaginationResult;
import dev.pedroenlanube.domain.model.user.Creator;
import dev.pedroenlanube.domain.model.user.query.SearchCreatorsQuery;

import java.util.function.Function;

public interface SearchCreatorsPort extends Function<SearchCreatorsQuery, PaginationResult<Creator>> {
}
