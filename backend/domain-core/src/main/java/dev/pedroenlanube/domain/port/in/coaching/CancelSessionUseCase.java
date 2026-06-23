package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.command.CancelSessionCmd;

import java.util.function.Consumer;

public interface CancelSessionUseCase extends Consumer<CancelSessionCmd> {
}
