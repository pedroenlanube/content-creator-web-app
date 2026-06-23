package dev.pedroenlanube.domain.port.out.coaching;

import dev.pedroenlanube.domain.model.coaching.CoachingSession;

import java.util.function.Consumer;

public interface SaveSessionPort extends Consumer<CoachingSession> {
}
