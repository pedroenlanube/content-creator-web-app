package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.command.RescheduleSessionCmd;

import java.util.function.Consumer;

public interface RescheduleSessionUseCase extends Consumer<RescheduleSessionCmd> {
}
