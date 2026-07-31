package dev.pedroenlanube.domain.core.port.in.coaching;

import dev.pedroenlanube.domain.core.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.core.model.coaching.query.ListAvailableSlotsQuery;

import java.util.List;
import java.util.function.Function;

public interface ListAvailableSlotsUseCase extends Function<ListAvailableSlotsQuery, List<CoachingSession>> {
}
