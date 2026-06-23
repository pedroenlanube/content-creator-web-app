package dev.pedroenlanube.domain.port.out.user;

import dev.pedroenlanube.domain.model.user.Creator;

import java.util.Optional;
import java.util.function.Function;

public interface LoadCreatorPort extends Function<String, Optional<Creator>> {
}
