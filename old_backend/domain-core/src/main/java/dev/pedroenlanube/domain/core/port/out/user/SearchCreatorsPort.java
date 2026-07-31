package dev.pedroenlanube.domain.core.port.out.user;

import dev.pedroenlanube.domain.core.model.generic.PaginationResult;
import dev.pedroenlanube.domain.core.model.user.User;
import dev.pedroenlanube.domain.core.model.user.query.SearchCreatorsQuery;

import java.util.function.Function;

public interface SearchCreatorsPort extends Function<SearchCreatorsQuery, PaginationResult<User>> {
}
