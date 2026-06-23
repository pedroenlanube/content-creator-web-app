package dev.pedroenlanube.domain.port.out.coaching;

import dev.pedroenlanube.domain.model.coaching.CoachingSession;

import java.util.Optional;
import java.util.function.Function;

public interface LoadSessionPort extends Function<String, Optional<CoachingSession>> {
}
