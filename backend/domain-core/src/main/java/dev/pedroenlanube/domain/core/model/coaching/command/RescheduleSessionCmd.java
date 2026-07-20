package dev.pedroenlanube.domain.core.model.coaching.command;

import java.time.Instant;

public record RescheduleSessionCmd(String creatorId, String subscriberId, Instant newInit, Instant newEnd) {
}
