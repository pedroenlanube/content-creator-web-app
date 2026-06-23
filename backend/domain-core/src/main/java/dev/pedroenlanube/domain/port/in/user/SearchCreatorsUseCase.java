package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.generic.PaginationResult;
import dev.pedroenlanube.domain.model.user.Creator;
import dev.pedroenlanube.domain.model.user.query.SearchCreatorsQuery;

import java.util.function.Function;

public interface SearchCreatorsUseCase extends Function<SearchCreatorsQuery, PaginationResult<Creator>> {
}
