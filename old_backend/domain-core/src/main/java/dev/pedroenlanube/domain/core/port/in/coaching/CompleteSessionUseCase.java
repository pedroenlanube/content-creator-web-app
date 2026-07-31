package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.command.CompleteSessionCmd;

import java.util.function.Consumer;

public interface CompleteSessionUseCase extends Consumer<CompleteSessionCmd> {
}
