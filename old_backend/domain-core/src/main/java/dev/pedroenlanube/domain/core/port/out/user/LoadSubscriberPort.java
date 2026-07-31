package dev.pedroenlanube.domain.core.port.out.user;

import dev.pedroenlanube.domain.core.model.generic.PaginationResult;
import dev.pedroenlanube.domain.core.model.user.User;

import java.util.function.Function;

public interface LoadSubscriberPort extends Function<String, PaginationResult<User>> {
}
