package dev.pedroenlanube.domain.core.port.out.user;

import dev.pedroenlanube.domain.core.model.user.User;

import java.util.Optional;
import java.util.function.Function;

public interface LoadCreatorPort extends Function<String, Optional<User>> {
}
