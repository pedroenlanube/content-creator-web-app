package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.command.DeleteSlotCmd;

import java.util.function.Consumer;

public interface DeleteSlotUseCase extends Consumer<DeleteSlotCmd> {
}
