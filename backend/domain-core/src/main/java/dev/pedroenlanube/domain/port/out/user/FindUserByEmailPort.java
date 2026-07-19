package dev.pedroenlanube.domain.port.out.user;

import dev.pedroenlanube.domain.model.user.User;

import java.util.Optional;
import java.util.function.Function;

public interface FindUserByEmailPort extends Function<String, Optional<User>> {}
