package dev.pedroenlanube.domain.model.coaching.query;

import java.time.Instant;

public record ListAvailableSlotsQuery(String creatorId, Instant from, Instant to) {
}
