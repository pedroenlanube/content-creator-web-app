package dev.pedroenlanube.domain.core.port.out.coaching;

import dev.pedroenlanube.domain.core.model.coaching.CoachingSession;

import java.util.Optional;
import java.util.function.Function;

public interface LoadSessionPort extends Function<String, Optional<CoachingSession>> {
}
