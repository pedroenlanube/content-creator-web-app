package dev.pedroenlanube.domain.core.port.in.user;

import dev.pedroenlanube.domain.core.model.generic.PaginationResult;
import dev.pedroenlanube.domain.core.model.user.User;
import dev.pedroenlanube.domain.core.model.user.query.SearchCreatorsQuery;

import java.util.function.Function;

public interface SearchCreatorsUseCase extends Function<SearchCreatorsQuery, PaginationResult<User>> {
}
