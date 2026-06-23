package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.command.RegisterUserCmd;

import java.util.function.Consumer;

public interface RegisterUserUseCase extends Consumer<RegisterUserCmd> {
}
