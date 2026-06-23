package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.model.coaching.command.CreateSlotCmd;

import java.util.function.Function;

public interface CreateSlotUseCase extends Function<CreateSlotCmd, CoachingSession> {
}
