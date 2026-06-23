package dev.pedroenlanube.domain.port.in.coaching;

import dev.pedroenlanube.domain.model.coaching.CoachingSession;
import dev.pedroenlanube.domain.model.coaching.query.ListAvailableSlotsQuery;

import java.util.List;
import java.util.function.Function;

public interface ListAvailableSlotsUseCase extends Function<ListAvailableSlotsQuery, List<CoachingSession>> {
}
