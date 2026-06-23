package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.command.ReserveSessionCmd;

import java.util.function.Consumer;

public interface ReserveSessionUseCase extends Consumer<ReserveSessionCmd> {
}
