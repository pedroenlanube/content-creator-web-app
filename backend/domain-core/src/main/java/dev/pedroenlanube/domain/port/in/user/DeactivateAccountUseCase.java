package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.command.DeactivateAccountCmd;

import java.util.function.Consumer;

public interface DeactivateAccountUseCase extends Consumer<DeactivateAccountCmd> {
}
