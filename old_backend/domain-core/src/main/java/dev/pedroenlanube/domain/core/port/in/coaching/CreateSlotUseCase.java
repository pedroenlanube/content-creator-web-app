package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.core.model.coaching.command.CreateSlotCmd;

import java.util.function.Function;

public interface CreateSlotUseCase extends Function<CreateSlotCmd, CoachingSession> {
}
