package dev.pedroenlanube.domain.core.model.coaching.query;

import dev.pedroenlanube.domain.core.model.coaching.CoachingState;
import dev.pedroenlanube.domain.core.model.user.UserRole;

import java.time.Instant;
import java.util.List;

public record ListUserSessionsQuery(
        String userId,
        UserRole role,
        List<CoachingState> filteredStates,
        Instant from,
        Instant to,
        int page,
        int pageSize
) {
}
