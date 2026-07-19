package dev.pedroenlanube.domain.port.out.user;

import dev.pedroenlanube.domain.model.generic.PaginationResult;
import dev.pedroenlanube.domain.model.user.User;

import java.util.function.Function;

public interface LoadSubscriberPort extends Function<String, PaginationResult<User>> {
}
