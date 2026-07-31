package dev.pedroenlanube.domain.core.port.in.user;

import dev.pedroenlanube.domain.core.model.user.command.DeactivateAccountCmd;

import java.util.function.Consumer;

public interface DeactivateAccountUseCase extends Consumer<DeactivateAccountCmd> {
}
