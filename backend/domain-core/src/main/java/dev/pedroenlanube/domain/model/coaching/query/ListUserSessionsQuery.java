package dev.pedroenlanube.domain.model.coaching.query;

import dev.pedroenlanube.domain.model.coaching.CoachingState;
import dev.pedroenlanube.domain.model.user.UserRole;

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
