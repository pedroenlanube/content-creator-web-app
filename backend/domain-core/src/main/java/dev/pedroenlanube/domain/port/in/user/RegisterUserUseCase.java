package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.User;

import java.util.function.Consumer;

public interface RegisterUserUseCase extends Consumer<User> {
}
