package dev.pedroenlanube.domain.port.out.coaching;

import dev.pedroenlanube.domain.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.model.coaching.query.ListUserSessionsQuery;
import dev.pedroenlanube.domain.model.generic.PaginationResult;

import java.util.function.Function;

public interface FindUserSessionsPort extends Function<ListUserSessionsQuery, PaginationResult<CoachingSession>> {
}
