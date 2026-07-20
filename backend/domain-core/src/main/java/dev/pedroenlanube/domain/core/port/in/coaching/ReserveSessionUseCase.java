package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.command.ReserveSessionCmd;

import java.util.function.Consumer;

public interface ReserveSessionUseCase extends Consumer<ReserveSessionCmd> {
}
