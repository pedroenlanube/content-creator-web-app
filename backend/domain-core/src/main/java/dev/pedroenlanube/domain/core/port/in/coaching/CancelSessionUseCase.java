package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.command.CancelSessionCmd;

import java.util.function.Consumer;

public interface CancelSessionUseCase extends Consumer<CancelSessionCmd> {
}
