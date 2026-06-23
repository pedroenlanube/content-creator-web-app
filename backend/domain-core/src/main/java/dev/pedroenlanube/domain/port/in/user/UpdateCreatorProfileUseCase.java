package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.command.UpdateCreatorProfileCmd;

import java.util.function.Consumer;

public interface UpdateCreatorProfileUseCase extends Consumer<UpdateCreatorProfileCmd> {
}
