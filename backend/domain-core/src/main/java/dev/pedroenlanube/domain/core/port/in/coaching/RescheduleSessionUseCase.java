package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.command.RescheduleSessionCmd;

import java.util.function.Consumer;

public interface RescheduleSessionUseCase extends Consumer<RescheduleSessionCmd> {
}
