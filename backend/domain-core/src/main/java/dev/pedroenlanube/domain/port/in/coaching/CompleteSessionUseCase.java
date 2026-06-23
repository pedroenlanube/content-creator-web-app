package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.command.CompleteSessionCmd;

import java.util.function.Consumer;

public interface CompleteSessionUseCase extends Consumer<CompleteSessionCmd> {
}
