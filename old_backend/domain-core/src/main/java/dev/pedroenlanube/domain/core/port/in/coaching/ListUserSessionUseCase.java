package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.core.model.coaching.query.ListUserSessionsQuery;
import dev.pedroenlanube.domain.core.model.generic.PaginationResult;

import java.util.function.Function;

public interface ListUserSessionUseCase extends Function<ListUserSessionsQuery, PaginationResult<CoachingSession>> {
}
