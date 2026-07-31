package dev.pedroenlanube.domain.core.port.in.user;

import dev.pedroenlanube.domain.core.model.user.User;

import java.util.function.Consumer;

public interface RegisterUserUseCase extends Consumer<User> {
}
