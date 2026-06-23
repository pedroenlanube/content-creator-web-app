package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.command.DeleteSlotCmd;

import java.util.function.Consumer;

public interface DeleteSlotUseCase extends Consumer<DeleteSlotCmd> {
}
