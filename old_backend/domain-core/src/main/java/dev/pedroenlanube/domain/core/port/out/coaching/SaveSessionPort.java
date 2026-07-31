package dev.pedroenlanube.domain.core.port.out.coaching;

import dev.pedroenlanube.domain.core.model.coaching.CoachingSession;

import java.util.function.Consumer;

public interface SaveSessionPort extends Consumer<CoachingSession> {
}
